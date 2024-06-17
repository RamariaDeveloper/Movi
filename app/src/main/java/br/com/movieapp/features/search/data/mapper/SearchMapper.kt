package br.com.movieapp.features.search.data.mapper

import br.com.movieapp.framework.domain.model.MovieSearch
import br.com.movieapp.framework.utils.toPostURL
import br.com.movieapp.remote.model.SearchResult

fun List<SearchResult>.toMovieSearch() = map { searchResult ->
    MovieSearch(
        id = searchResult.id,
        imageUrl = searchResult.posterPath.toPostURL(),
        voteAvarage = searchResult.voteAverage
    )
}