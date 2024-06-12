package br.com.movieapp.framework.di

import br.com.movieapp.BuildConfig
import br.com.movieapp.ParamsInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val TIMEOUT_SECONDS = 15L

    @Provides
    fun provideParamsInterceptor(): ParamsInterceptor {
        return ParamsInterceptor()
    }

    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = getLoggingInterceptorLevel()
        }
    }

    private fun getLoggingInterceptorLevel(): HttpLoggingInterceptor.Level {
        return if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

}