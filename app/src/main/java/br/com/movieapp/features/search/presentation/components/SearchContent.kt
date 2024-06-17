package br.com.movieapp.features.search.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import br.com.movieapp.features.search.presentation.MovieSearchEvent
import br.com.movieapp.framework.domain.model.MovieSearch
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

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(black),
        verticalArrangement = Arrangement.SpaceBetween,
    ){
        SearchComponent(
            query = query,
            onSearch = {
                onSearch(it)
            },
            onQueryChangeEvent = {

            }
        )
    }

}
