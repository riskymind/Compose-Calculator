package com.asterisk.calculator.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val _uiState = mutableStateOf(CalculatorScreenState())
    val uiState: State<CalculatorScreenState> = _uiState

    fun onEvents(events: CalculatorScreenEvents) {
        when (events) {
            CalculatorScreenEvents.Clear -> _uiState.value = CalculatorScreenState()
            CalculatorScreenEvents.Decimal -> enterDecimal()
            CalculatorScreenEvents.DeleteLastItem -> deleteLastItem()
            CalculatorScreenEvents.Equate -> calculate()
            is CalculatorScreenEvents.Number -> {
                enterNumber(events.input)
            }
            is CalculatorScreenEvents.Operation -> {
                enterOperator(events.operation)
            }
        }
    }

    private fun deleteLastItem() {
        when {
            _uiState.value.number2.isNotBlank() -> _uiState.value = _uiState.value.copy(
                number2 = _uiState.value.number2.dropLast(1)
            )

            _uiState.value.operation != null -> _uiState.value = _uiState.value.copy(
                operation = null
            )

            _uiState.value.number1.isNotBlank() -> _uiState.value = _uiState.value.copy(
                number1 = _uiState.value.number1.dropLast(1)
            )
        }
    }

    private fun calculate() {
        val number1 = _uiState.value.number1.toDoubleOrNull()
        val number2 = _uiState.value.number2.toDoubleOrNull()

        if (number1 != null && number2 != null) {
            val result = when (_uiState.value.operation) {
                CalculatorOperation.Addition -> number1 + number2
                CalculatorOperation.Division -> number1 / number2
                CalculatorOperation.Multiplication -> number1 * number2
                CalculatorOperation.Subtraction -> number1 - number2
                null -> return
            }

            _uiState.value = _uiState.value.copy(
                number1 = result.toString(),
                number2 = "",
                operation = null
            )
        }
    }

    private fun enterDecimal() {
        if (_uiState.value.operation == null && _uiState.value.number1.isNotBlank() &&
            !_uiState.value.number1.contains(".")
        ) {
            _uiState.value = _uiState.value.copy(
                number1 = _uiState.value.number1 + "."
            )
            return
        } else if (_uiState.value.number2.isNotBlank() && !_uiState.value.number2.contains(".")
        ) {
            _uiState.value = _uiState.value.copy(
                number2 = _uiState.value.number2 + "."
            )
        }
    }

    private fun enterOperator(operation: CalculatorOperation) {
        if (_uiState.value.number1.isNotBlank()) {
            _uiState.value = _uiState.value.copy(operation = operation)
        }
    }

    private fun enterNumber(input: Int) {
        if (_uiState.value.operation == null) {
            if (_uiState.value.number1.length > 9) return
            _uiState.value = _uiState.value.copy(number1 = _uiState.value.number1 + input)
            return
        }

        if (_uiState.value.number2.length >= 9) return
        _uiState.value = _uiState.value.copy(number2 = _uiState.value.number2 + input)
    }
}