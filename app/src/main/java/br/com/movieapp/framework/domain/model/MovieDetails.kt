package br.com.movieapp.framework.domain.model

data class MovieDetails(
    val id: Int,
    val title: String,
    val genres: List<String>,
    val overview: String?,
    val backdropPathUrl: String?,
    val releaseDate: String?,
    val voteAvarage: Double = 0.0,
    val duration: Int = 0,
    val votecCount: Int = 0
)
