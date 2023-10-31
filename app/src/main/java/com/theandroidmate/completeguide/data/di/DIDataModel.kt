package com.theandroidmate.completeguide.data.di

import com.theandroidmate.completeguide.data.repository.INewsRepository
import com.theandroidmate.completeguide.data.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ConnectionModule {
    private const val baseUrl = "https://newsapi.org/v2/"

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModules {
    @Binds
    fun providesLatestNewsRepository(repository: NewsRepository): INewsRepository

}