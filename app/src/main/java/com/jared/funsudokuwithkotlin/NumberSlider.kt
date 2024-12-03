/*
 * Author: Jared Scott
 * Date: 12/3/2024
 */

package com.jared.funsudokuwithkotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberSlider(onNumberSelected: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        (1..9).forEach { number ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Cyan)
                    .clickable { onNumberSelected(number) }
            ) {
                Text(
                    text = number.toString(),
                    fontSize = 20.sp
                )
            }
        }
    }
}