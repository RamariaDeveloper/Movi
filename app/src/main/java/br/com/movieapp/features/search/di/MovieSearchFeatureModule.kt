package br.com.movieapp.features.search.di

import br.com.movieapp.features.search.data.repository.MovieSearchRepositoryImpl
import br.com.movieapp.features.search.data.source.MovieSearchRemoteDataSourceImpl
import br.com.movieapp.features.search.domain.repository.MovieSearchRepository
import br.com.movieapp.features.search.domain.source.MovieSearchRemoteDataSource
import br.com.movieapp.features.search.domain.usecase.GetMovieSearchUseCase
import br.com.movieapp.features.search.domain.usecase.GetMovieSearchUseCaseImpl
import br.com.movieapp.remote.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MovieSearchFeatureModule {

    @Provides
    @Singleton
    fun provideMovieSearchDataSource(service: MovieService): MovieSearchRemoteDataSource {
        return MovieSearchRemoteDataSourceImpl(service = service)
    }

    @Provides
    @Singleton
    fun provideMovieSearchRepository(remoteDataSource: MovieSearchRemoteDataSource): MovieSearchRepository {
        return MovieSearchRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMovieSearchUseCase(repository: MovieSearchRepository): GetMovieSearchUseCase {
        return GetMovieSearchUseCaseImpl(repository = repository)
    }
}