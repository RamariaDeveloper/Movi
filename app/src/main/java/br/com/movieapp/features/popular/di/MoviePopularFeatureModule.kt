package br.com.movieapp.features.popular.di

import br.com.movieapp.features.popular.data.repository.MoviePopularRepositoryImpl
import br.com.movieapp.features.popular.data.source.MoviePopularRemoteDataSourceImpl
import br.com.movieapp.features.popular.domain.repository.MoviePopularRepository
import br.com.movieapp.features.popular.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.features.popular.domain.usecase.GetPopularMoviesUseCase
import br.com.movieapp.features.popular.domain.usecase.GetPopularMoviesUseCaseImpl
import br.com.movieapp.remote.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // TODO rememeber dependencies
class MoviePopularFeatureModule {
    @Provides // TODO to provide instance of MoviePopularRemoteDataSourceImpl
    @Singleton //TODO same instance for all child claasses
    fun provideMovieDataSource(service: MovieService): MoviePopularRemoteDataSource {
        return MoviePopularRemoteDataSourceImpl(service = service)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(remoteDataSource: MoviePopularRemoteDataSource): MoviePopularRepository {
        return MoviePopularRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideMovieRepositoryPopularUsecase(moviePopularRepository: MoviePopularRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCaseImpl(repository = moviePopularRepository)
    }
}