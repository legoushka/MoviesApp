package com.example.moviesapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.moviesapp.data.models.Movies
import com.example.moviesapp.presentation.MainViewModel
import com.example.moviesapp.presentation.navigation.Screens

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
        ) {
            items(allMovies.take(10)) { item ->
                MovieItem(item = item, navController = navController)
            }
        }
    }
}

@Composable
fun MovieItem(item: Movies, navController: NavController) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .clickable {
                navController.navigate(Screens.Details.route + "/${item.id}")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = rememberImagePainter(item.image.medium),
                contentDescription = "Movie poster",
                modifier = Modifier
                    .size(128.dp)
            )
            Column {
                Text(text = item.name, style = MaterialTheme.typography.h5)
                Row {
                    Text(text = "Rating: ", style = MaterialTheme.typography.body1)
                    Text(
                        text = item.rating.average.toString(),
                        style = MaterialTheme.typography.body1
                    )
                }
                Row {
                    Text(text = "Genre: ", style = MaterialTheme.typography.body1)
                    item.genres.take(2).forEach {
                        Text(text = " $it ", style = MaterialTheme.typography.body1)
                    }
                }
                Row {
                    Text(text = "Premiered: ", style = MaterialTheme.typography.body1)
                    Text(text = item.premiered, style = MaterialTheme.typography.body1)
                }
            }

        }
    }
}
