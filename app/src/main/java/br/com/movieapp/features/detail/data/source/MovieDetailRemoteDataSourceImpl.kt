package br.com.movieapp.features.detail.data.source

import br.com.movieapp.features.detail.domain.source.MovieDetailRemoteDataSource
import br.com.movieapp.framework.domain.model.MovieDetails
import br.com.movieapp.framework.paging.MovieSimilarPagingSource
import br.com.movieapp.framework.utils.toBackdropURL
import br.com.movieapp.remote.MovieService
import br.com.movieapp.remote.model.MovieResponse
import javax.inject.Inject

class MovieDetailRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MovieDetailRemoteDataSource {
    override suspend fun getMoviesDetails(movieId: Int): MovieDetails {
        val response = service.getMovie(movieId)
        val genres = response.genres.map { it.name }
        return MovieDetails(
            id = response.id,
            title = response.title,
            overview = response.overview,
            genres = genres,
            releaseDate = response.releaseDate,
            backdropPathUrl = response.backdropPath.toBackdropURL(),
            voteAvarage = response.voteAverage,
            duration = response.runtime,
            votecCount = response.voteCount

        )
    }

    override suspend fun getMovieSimilar(page: Int, movieId: Int): MovieResponse {
        return service.getMoviesSimilar(page = page, movieId = movieId)
    }

    override fun getSimilarMoviesPagingSource(movieId: Int): MovieSimilarPagingSource {
        return MovieSimilarPagingSource(this, movieId = movieId)
    }
}