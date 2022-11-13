package com.asterisk.calculator.ui

sealed class CalculatorOperation(val symbol: String) {
    object Addition : CalculatorOperation("+")
    object Subtraction : CalculatorOperation("-")
    object Division : CalculatorOperation("/")
    object Multiplication : CalculatorOperation("*")
}
