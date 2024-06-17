package br.com.movieapp.features.search.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.features.search.domain.repository.MovieSearchRepository
import br.com.movieapp.framework.domain.model.MovieSearch
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetMovieSearchUseCase {
    operator fun invoke(params: Params): Flow<PagingData<MovieSearch>>
    data class Params(val query: String)
}

class GetMovieSearchUseCaseImpl @Inject constructor(
    private val repository: MovieSearchRepository
) : GetMovieSearchUseCase {
    override fun invoke(params: GetMovieSearchUseCase.Params): Flow<PagingData<MovieSearch>> {
        return repository.getSearchMovies(
            query = params.query,
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        )
    }

}