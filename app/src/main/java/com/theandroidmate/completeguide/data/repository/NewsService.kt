package com.theandroidmate.completeguide.data.repository

import com.theandroidmate.completeguide.data.model.ArticleHeadline
import com.theandroidmate.completeguide.data.model.ArticleList
import retrofit2.http.GET

interface NewsService {

    @GET("everything?apiKey=12242c24e5f64d5f81e30be2ce7e14c6&q=android/")
    suspend fun latestNews(): ArticleList

}