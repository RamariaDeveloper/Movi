package br.com.movieapp.features.popular.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.framework.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviePopularRepository {

    fun getpopularMovies(pagingConfig: PagingConfig): Flow<PagingData<Movie>>
}