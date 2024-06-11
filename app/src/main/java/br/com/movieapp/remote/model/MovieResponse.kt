package br.com.movieapp.remote.model

import br.com.movieapp.remote.response.MovieResult

data class MovieResponse(
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)