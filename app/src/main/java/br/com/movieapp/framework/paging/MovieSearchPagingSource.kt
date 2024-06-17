package br.com.movieapp.framework.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.movieapp.features.search.domain.source.MovieSearchRemoteDataSource
import br.com.movieapp.framework.domain.model.MovieSearch

class MovieSearchPagingSource(
    private val query: String,
    private val remoteDataSource: MovieSearchRemoteDataSource
) : PagingSource<Int, MovieSearch>() {
    override fun getRefreshKey(state: PagingState<Int, MovieSearch>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieSearch> {
        TODO("Not yet implemented")
    }
}