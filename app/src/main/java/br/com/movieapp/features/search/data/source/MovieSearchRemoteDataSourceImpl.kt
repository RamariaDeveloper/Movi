package br.com.movieapp.features.search.data.source

import br.com.movieapp.features.search.domain.source.MovieSearchRemoteDataSource
import br.com.movieapp.framework.paging.MovieSearchPagingSource
import br.com.movieapp.remote.MovieService
import br.com.movieapp.remote.response.SearchResponse

class MovieSearchRemoteDataSourceImpl constructor(
    private val service: MovieService
) : MovieSearchRemoteDataSource {
    override fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource {
        return MovieSearchPagingSource(query = query, remoteDataSource = this)
    }

    override suspend fun getSearchMovies(page: Int, query: String): SearchResponse {
        return service.searchMovie(page, query)
    }
}