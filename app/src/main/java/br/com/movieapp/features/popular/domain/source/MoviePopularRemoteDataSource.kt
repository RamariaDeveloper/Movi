package br.com.movieapp.features.popular.domain.source

import br.com.movieapp.remote.model.MovieResponse

interface MoviePopularRemoteDataSource {

    suspend fun getPopularMovies(page: Int): MovieResponse

}