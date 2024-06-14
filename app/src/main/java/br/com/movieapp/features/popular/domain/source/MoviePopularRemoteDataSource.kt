package br.com.movieapp.features.popular.domain.source

import br.com.movieapp.framework.paging.MoviePaggingSource
import br.com.movieapp.remote.model.MovieResponse

interface MoviePopularRemoteDataSource {

    fun getPopularMoviesPagingSource(): MoviePaggingSource
    suspend fun getPopularMovies(page: Int): MovieResponse

}