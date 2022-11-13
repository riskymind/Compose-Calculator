package com.asterisk.calculator.ui

data class CalculatorScreenState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
)
