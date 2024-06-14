package br.com.movieapp.features.popular.presentation

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.movieapp.R
import br.com.movieapp.features.popular.presentation.components.MovieContent
import br.com.movieapp.features.popular.presentation.state.MoviePopularState
import br.com.movieapp.framework.utils.UtilFunctions
import br.com.movieapp.ui.theme.MovieAppTheme
import br.com.movieapp.ui.theme.black
import br.com.movieapp.ui.theme.white
import kotlinx.coroutines.flow.flowOf

@Composable
fun MoviePopularScreen(
    uiState: MoviePopularState,
    navigateToDetailMovie: (Int) -> Unit
) {
    val movies = uiState.movies.collectAsLazyPagingItems()


    Scaffold(
        topBar = {
            TopAppBar(
                title =
                {
                    Text(
                        text = stringResource(id = R.string.popular_movies),
                        color = white
                    )
                },
                backgroundColor = black
            )
        },
        content = { paddingValues ->
            MovieContent(
                pagingMovies = movies,
                paddingValues = paddingValues,
                onClick = { movieId ->
                    UtilFunctions.logInfo("MOVIE_ID", movieId.toString())
                    navigateToDetailMovie(movieId)
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMoviePopularScreen() {
    MovieAppTheme {
        MoviePopularScreen(
            uiState = MoviePopularState(
                movies = flowOf(PagingData.empty())
            ),
            navigateToDetailMovie = {}
        )
    }
}