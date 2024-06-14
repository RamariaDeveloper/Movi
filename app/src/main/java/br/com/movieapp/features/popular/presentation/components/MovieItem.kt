package br.com.movieapp.features.popular.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    voteAvarage: Double,
    imageUrl: String,
    id: Int,
    onClick: (id: Int) -> Unit

) {

    Box(
        modifier = modifier,
    ) {
        MovieRate(
            rate = voteAvarage,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .zIndex(2f)
                .padding(start = 6.dp, bottom = 8.dp)
                .background(Color.Black)
        )
        Card(
            modifier = Modifier
                .fillMaxSize()
                .height(200.dp)
                .padding(4.dp)
                .clickable { onClick(id) },
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        ) {

        }
    }
}