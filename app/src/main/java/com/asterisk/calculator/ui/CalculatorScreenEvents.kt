package com.asterisk.calculator.ui

sealed class CalculatorScreenEvents {
    data class Number(val input: Int) : CalculatorScreenEvents()
    object Clear : CalculatorScreenEvents()
    object DeleteLastItem : CalculatorScreenEvents()
    object Decimal : CalculatorScreenEvents()
    object Equate : CalculatorScreenEvents()
    data class Operation(val operation: CalculatorOperation) : CalculatorScreenEvents()
}
