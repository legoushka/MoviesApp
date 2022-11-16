package com.example.moviesapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.moviesapp.presentation.MainViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DetailsScreen(viewModel: MainViewModel, itemId: String) {
    val currentItem = viewModel.allMovies
        .observeAsState(listOf()).value
        .firstOrNull { it.id == itemId.toInt() }

    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Surface(modifier = Modifier.fillMaxSize().padding(vertical = 24.dp, horizontal = 8.dp)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberImagePainter(currentItem?.image?.medium),
                    contentDescription = "Movie poster",
                    modifier = Modifier
                        .size(512.dp)
                )
                Text(
                    text = currentItem?.name ?: "Null",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
            }
        }
    }
}