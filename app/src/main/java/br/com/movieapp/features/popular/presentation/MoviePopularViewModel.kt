package br.com.movieapp.features.popular.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.movieapp.features.popular.domain.usecase.GetPopularMoviesUseCase
import br.com.movieapp.features.popular.presentation.state.MoviePopularState
import javax.inject.Inject

class MoviePopularViewModel @Inject constructor(
    getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
    var uiState by mutableStateOf(MoviePopularState())
        private set

    init {
        val movies = getPopularMoviesUseCase.invoke()
            .cachedIn(viewModelScope)
        uiState = uiState.copy(movies = movies)
    }
}