package com.example.movieapps.presentation.movie_screen.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapps.domain.model.Movie

@Composable
fun MovieListItem(
    result: Movie,
    onItemClick: (Movie) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(result) }
        .padding(
            20.dp
        )) {
        Text(text = result.dates.maximum)
        Log.d("TAG", "MovieListItem:" + result.dates.maximum)
    }

}