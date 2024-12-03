/*
 * Author: Jared Scott
 * Date: 12/3/2024
 */

package com.jared.funsudokuwithkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    private lateinit var sudokuViewModel: SudokuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sudokuViewModel = ViewModelProvider(this)[SudokuViewModel::class.java]

        setContent {
            SudokuApp(viewModel = sudokuViewModel)
        }
    }
}

@Composable
fun SudokuApp(viewModel: SudokuViewModel) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.unique_background),
            contentDescription = null, // No description needed for decorative background
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Sudoku UI overlaid on the background
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Top half of the screen
                    .padding(16.dp)
            ) {
                SudokuGrid(
                    grid = viewModel.sudokuGrid,
                    onCellSelected = viewModel::onCellSelected,
                    isCellSelected = viewModel::isCellSelected,
                    isCellEditable = viewModel::isCellEditable
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f) // Bottom half of the screen
                    .padding(16.dp)
            ) {
                NumberSlider(onNumberSelected = viewModel::onNumberSelected)
            }
        }
    }
}