package com.theandroidmate.completeguide.ui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.theandroidmate.completeguide.data.model.ArticleHeadline

@Composable
fun FavoriteNewsComponent(articles: List<ArticleHeadline>) {
    LazyColumn {
        items(articles){ article ->
            ArticleComponent(article)
        }
    }
}

@Composable
fun ArticleComponent(article: ArticleHeadline) {
    Text(text = article.title)
}

@Composable
fun ErrorComponent(error: Throwable){

}