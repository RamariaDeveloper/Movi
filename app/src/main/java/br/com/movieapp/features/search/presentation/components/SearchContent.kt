package br.com.movieapp.features.search.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import br.com.movieapp.R
import br.com.movieapp.features.popular.presentation.components.MovieItem
import br.com.movieapp.features.search.presentation.MovieSearchEvent
import br.com.movieapp.framework.domain.model.MovieSearch
import br.com.movieapp.framework.presentation.components.common.ErrorScreen
import br.com.movieapp.framework.presentation.components.common.LoadingView
import br.com.movieapp.ui.theme.black

@Composable
fun SearchContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    pagingMovies: LazyPagingItems<MovieSearch>,
    query: String,
    onSearch: (String) -> Unit,
    onEvent: (MovieSearchEvent) -> Unit,
    onDetails: (movieId: Int) -> Unit
) {

    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(black),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        SearchComponent(
            query = query,
            onSearch = {
                isLoading = true
                onSearch(it)
            },
            onQueryChangeEvent = {
                onEvent(it)
            },
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            modifier = Modifier.fillMaxSize()
        ) {
            items(pagingMovies.itemCount) { index ->
                val movie = pagingMovies[index]
                movie?.let {
                    MovieItem(
                        voteAvarage = it.voteAvarage,
                        imageUrl = it.imageUrl,
                        id = it.id,
                        onClick = { movieId ->
                            onDetails(movieId)
                        }
                    )
                }
                isLoading = false
            }
            pagingMovies.apply {
                when {
                    isLoading -> {
                        item(span = {
                            GridItemSpan(maxLineSpan)
                        }) {
                            LoadingView()
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        isLoading = false
                        item(span = {
                            GridItemSpan(maxLineSpan)
                        }) {
                            LoadingView()
                        }
                    }

                    loadState.refresh is LoadState.Error -> {
                        isLoading = false
                        item(span = {
                            GridItemSpan(maxLineSpan)
                        }) {
                            ErrorScreen(message = stringResource(R.string.check_your_internet_connection),
                                retry = {
                                    retry()
                                })
                        }
                    }
                }

            }
        }
    }

}
