package com.theandroidmate.completeguide.data.repository

import com.theandroidmate.completeguide.data.model.ArticleHeadline
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
): INewsRepository {

    override suspend fun latestNews(): Flow<List<ArticleHeadline>> = newsDataSource.latestNews
}