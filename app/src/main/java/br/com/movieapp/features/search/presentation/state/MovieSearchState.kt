package br.com.movieapp.features.search.presentation.state

import androidx.paging.PagingData
import br.com.movieapp.framework.domain.model.MovieSearch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MovieSearchState(
    val query: String = "",
    val movies: Flow<PagingData<MovieSearch>> = emptyFlow()
)
