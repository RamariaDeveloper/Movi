package br.com.movieapp.features.search.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.movieapp.features.search.domain.usecase.GetMovieSearchUseCase
import br.com.movieapp.features.search.presentation.state.MovieSearchState
import javax.inject.Inject

class MovieSearchViewModel @Inject constructor(
    private val getMovieSearchUseCase: GetMovieSearchUseCase
) : ViewModel() {
    var uiState by mutableStateOf(MovieSearchState())
        private set

    fun fetch(query: String = "") {
        val movies = getMovieSearchUseCase.invoke(
            params = GetMovieSearchUseCase.Params(
                query = query
            )
        ).cachedIn(viewModelScope)
        uiState = uiState.copy(movies = movies)
    }

    fun event(event: MovieSearchEvent) {
        uiState = when (event) {
            is MovieSearchEvent.EnteredQuery -> {
                uiState.copy(query = event.value)
            }
        }
    }

}