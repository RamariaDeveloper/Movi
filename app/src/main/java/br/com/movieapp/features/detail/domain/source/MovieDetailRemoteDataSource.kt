package br.com.movieapp.features.detail.domain.source

import br.com.movieapp.framework.domain.model.MovieDetails
import br.com.movieapp.framework.paging.MovieSimilarPagingSource
import br.com.movieapp.remote.model.MovieResponse

interface MovieDetailRemoteDataSource {

    suspend fun getMoviesDetails(movieId: Int): MovieDetails
    suspend fun getMovieSimilar(page: Int, movieId: Int): MovieResponse
    fun getSimilarMoviesPagingSource(movieId: Int): MovieSimilarPagingSource
}