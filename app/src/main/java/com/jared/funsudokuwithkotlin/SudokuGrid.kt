/*
 * Author: Jared Scott
 * Date: 12/3/2024
 */

package com.jared.funsudokuwithkotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SudokuGrid(
    grid: Array<IntArray>,
    onCellSelected: (Int, Int) -> Unit,
    isCellSelected: (Int, Int) -> Boolean,
    isCellEditable: (Int, Int) -> Boolean
) {
    Column(modifier = Modifier.padding(16.dp)) {
        for (row in grid.indices) {
            Row {
                for (col in grid[row].indices) {
                    SudokuCell(
                        value = grid[row][col],
                        isSelected = isCellSelected(row, col),
                        isEditable = isCellEditable(row, col),
                        onClick = { onCellSelected(row, col) },
                        modifier = Modifier
                            .size(40.dp)
                            .border(1.dp, Color.Black)
                    )
                }
            }
        }
    }
}

@Composable
fun SudokuCell(value: Int, isSelected: Boolean, isEditable: Boolean, onClick: () -> Unit, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                when {
                    isSelected -> Color.Yellow
                    isEditable -> Color.LightGray
                    else -> Color.LightGray
                }
            )
            .clickable { onClick() }
    ) {
        Text(
            text = if (value == 0) "" else value.toString(),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}