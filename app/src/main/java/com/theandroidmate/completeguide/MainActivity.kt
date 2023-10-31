package com.theandroidmate.completeguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.theandroidmate.completeguide.data.viewmodel.LatestNewsUiState
import com.theandroidmate.completeguide.data.viewmodel.LatestNewsViewModel
import com.theandroidmate.completeguide.ui.component.ErrorComponent
import com.theandroidmate.completeguide.ui.component.FavoriteNewsComponent
import com.theandroidmate.completeguide.ui.theme.CompleteGuideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompleteGuideTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val latestNewsViewModel: LatestNewsViewModel = hiltViewModel()
                    val uiState by latestNewsViewModel.uiState.collectAsStateWithLifecycle()

                    when (uiState) {
                        is LatestNewsUiState.Success -> FavoriteNewsComponent((uiState as LatestNewsUiState.Success).news)
                        is LatestNewsUiState.Error -> ErrorComponent((uiState as LatestNewsUiState.Error).exception)
                    }
                }
            }
        }
    }
}