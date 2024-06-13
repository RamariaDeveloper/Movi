package br.com.movieapp.features.popular.data.mapper

import br.com.movieapp.framework.domain.model.Movie
import br.com.movieapp.framework.utils.toPostURL
import br.com.movieapp.remote.response.MovieResult

fun List<MovieResult>.toMovie() = map { movieResult ->
    Movie(
        id = movieResult.id,
        title = movieResult.title,
        voteAvarage = movieResult.voteAverage,
        imageUrl = movieResult.posterPath?.toPostURL() ?: ""


    )
}