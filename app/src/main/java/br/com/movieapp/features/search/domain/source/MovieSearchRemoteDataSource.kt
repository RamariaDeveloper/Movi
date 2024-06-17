package br.com.movieapp.features.search.domain.source

import br.com.movieapp.framework.paging.MovieSearchPagingSource
import br.com.movieapp.remote.response.SearchResponse

interface MovieSearchRemoteDataSource {
    fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource
    suspend fun getSearchMovies(page: Int, query: String): SearchResponse
}