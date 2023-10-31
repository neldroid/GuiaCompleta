package com.theandroidmate.completeguide.data.repository

import com.theandroidmate.completeguide.data.model.ArticleHeadline
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import javax.inject.Inject

class NewsDataSource @Inject constructor(
    private val retrofit: Retrofit
) {

    val latestNews: Flow<List<ArticleHeadline>> = flow {
        val newsService = retrofit.create(NewsService::class.java)

        emit(newsService.latestNews().articles)
    }

}