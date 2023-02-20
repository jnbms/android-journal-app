package com.example.streotypenote.Components

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun DesignedCard() {
  Card(
    backgroundColor = Color.White,
    elevation = 20.dp

  ) {
    Text(text = "CARD")
  }
}