package com.example.movieapplication.themoviedb_module

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@Composable
fun FavoriteScreen(vm: TheMovieViewModel, navController: NavHostController) {
    // Get the favorite movies
    val favoriteMovies = vm.favoriteMovies

    // Map FavoriteMovie to Result
    val favoriteMoviesAsResult = favoriteMovies.map { favoriteMovie ->
        Result(
            id = favoriteMovie.id,
            title = favoriteMovie.title,
            posterPath = favoriteMovie.posterPath,
            overview = "",
            originalLanguage = "",
            video = false,
            genreIDS = emptyList(),
            backdropPath = "",
            releaseDate = "",
            popularity = 0.0,
            voteAverage = 0.0,
            adult = false,
            voteCount = 0,
            originalTitle = favoriteMovie.title // Assuming originalTitle is the same as title
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF27272A)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(favoriteMoviesAsResult) { movie ->
            TheMovieItem(
                item = movie,
                isGridLayout = false,
                vm = vm,
                navController = navController
            )
        }
    }
}
