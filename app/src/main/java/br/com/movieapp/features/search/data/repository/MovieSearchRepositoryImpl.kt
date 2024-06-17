package br.com.movieapp.features.search.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.features.search.domain.repository.MovieSearchRepository
import br.com.movieapp.features.search.domain.source.MovieSearchRemoteDataSource
import br.com.movieapp.framework.domain.model.MovieSearch
import kotlinx.coroutines.flow.Flow

class MovieSearchRepositoryImpl constructor(
    private val remoteDataSource: MovieSearchRemoteDataSource
) : MovieSearchRepository {
    override fun getSearchMovies(
        query: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<MovieSearch>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getSearchMoviePagingSource(query = query)
            }
        ).flow
    }
}