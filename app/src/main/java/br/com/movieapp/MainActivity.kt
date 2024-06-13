package br.com.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import br.com.movieapp.framework.presentation.MainScreen
import br.com.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apiKey = BuildConfig.API_KEY
        setContent {
            MovieAppTheme {
                MainScreen(navController = rememberNavController())
            }
        }
    }
}
