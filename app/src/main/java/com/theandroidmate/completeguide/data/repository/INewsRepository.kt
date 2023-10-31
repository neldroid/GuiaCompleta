package com.theandroidmate.completeguide.data.repository

import com.theandroidmate.completeguide.data.model.ArticleHeadline
import kotlinx.coroutines.flow.Flow

interface INewsRepository {

    suspend fun latestNews(): Flow<List<ArticleHeadline>>
}