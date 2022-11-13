package com.example.moviesapp.presentation.screens

import androidx.compose.animation.core.EaseInOutExpo
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapp.presentation.MainViewModel
import com.example.moviesapp.presentation.navigation.Screens
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController, viewModel: MainViewModel) {
    var startAnimation by remember {
        mutableStateOf(false)
    }

    val rotateAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 360f else 0f,
        animationSpec = tween(
            durationMillis = 3000,
            easing = EaseInOutExpo
        )
    )
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000,
            easing = EaseInOutExpo
        )
    )
    LaunchedEffect(key1 = true ){
        startAnimation = true
        viewModel.getAllMovies()
        delay(3500)
        navController.navigate(Screens.Main.route)
    }
    Splash(alpha = alphaAnimation.value, rotation = rotateAnimation.value)
}

@Composable
fun Splash(alpha: Float, rotation: Float){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .rotate(degrees = rotation),
        contentAlignment = Alignment.Center,

    ){
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            imageVector = Icons.Default.ThumbUp,
            contentDescription = "Splash screen logo",
            tint = MaterialTheme.colors.primaryVariant
        )
    }
}

