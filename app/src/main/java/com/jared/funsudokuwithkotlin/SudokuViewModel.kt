/*
 * Author: Jared Scott
 * Date: 12/3/2024
 */

package com.jared.funsudokuwithkotlin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SudokuViewModel : ViewModel() {
    var sudokuGrid by mutableStateOf(RandomPuzzleGenerator.generatePuzzle())
        private set

    // Track the cells that the user can modify
    private val editableCells = Array(9) { row ->
        BooleanArray(9) { col -> sudokuGrid[row][col] == 0 }
    }

    // Track the currently selected cell
    private var selectedCell by mutableStateOf<Pair<Int, Int>?>(null)

    fun onNumberSelected(number: Int) {
        selectedCell?.let { (row, col) ->
            if (editableCells[row][col]) {
                // Update grid with the selected number
                val updatedGrid = sudokuGrid.map { it.copyOf() }.toTypedArray()
                updatedGrid[row][col] = number
                sudokuGrid = updatedGrid
            }
        }
    }

    fun onCellSelected(row: Int, col: Int) {
        selectedCell = Pair(row, col)
    }

    fun isCellSelected(row: Int, col: Int): Boolean {
        return selectedCell == Pair(row, col)
    }

    fun isCellEditable(row: Int, col: Int): Boolean {
        return editableCells[row][col]
    }
}