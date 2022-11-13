package com.asterisk.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asterisk.calculator.ui.components.CalculatorButton
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel(),
) {
    val uiState = viewModel.uiState.value

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(16.dp)
    ) {
        Column(
            modifier = modifier.align(Alignment.BottomEnd),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = uiState.number1 + (uiState.operation?.symbol ?: "") + uiState.number2,
                maxLines = 2,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontSize = 60.sp,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colors.onBackground
            )

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    color = MaterialTheme.colors.secondary,
                    textColor = MaterialTheme.colors.onSecondary,
                    modifier = modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    // clear result
                    viewModel.onEvents(CalculatorScreenEvents.Clear)
                }
                CalculatorButton(
                    symbol = "C",
                    color = MaterialTheme.colors.secondary,
                    textColor = MaterialTheme.colors.onSecondary,
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    // delete the last item on the screen
                    viewModel.onEvents(CalculatorScreenEvents.DeleteLastItem)
                }
                CalculatorButton(symbol = "/", modifier = modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                    // call the division operation
                    viewModel.onEvents(CalculatorScreenEvents.Operation(CalculatorOperation.Division))
                }
            }

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onEvents(CalculatorScreenEvents.Number(7))
                }
                CalculatorButton(
                    symbol = "8",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onEvents(CalculatorScreenEvents.Number(8))
                }
                CalculatorButton(symbol = "9", modifier = modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                    viewModel.onEvents(CalculatorScreenEvents.Number(9))
                }

                CalculatorButton(symbol = "*", modifier = modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                    // call the multiplication operation
                    viewModel.onEvents(CalculatorScreenEvents.Operation(CalculatorOperation.Multiplication))
                }
            }

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onEvents(CalculatorScreenEvents.Number(4))
                }
                CalculatorButton(
                    symbol = "5",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onEvents(CalculatorScreenEvents.Number(5))
                }
                CalculatorButton(symbol = "6", modifier = modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                    viewModel.onEvents(CalculatorScreenEvents.Number(6))
                }

                CalculatorButton(symbol = "-", modifier = modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                    // call the subtraction operation
                    viewModel.onEvents(CalculatorScreenEvents.Operation(CalculatorOperation.Subtraction))
                }
            }

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onEvents(CalculatorScreenEvents.Number(1))
                }
                CalculatorButton(
                    symbol = "2",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onEvents(CalculatorScreenEvents.Number(2))
                }
                CalculatorButton(
                    symbol = "3",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)) {
                    viewModel.onEvents(CalculatorScreenEvents.Number(3))
                }

                CalculatorButton(
                    symbol = "+",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)) {
                    // call the addition operation
                    viewModel.onEvents(CalculatorScreenEvents.Operation(CalculatorOperation.Addition))
                }
            }

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                CalculatorButton(
                    symbol = "0",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onEvents(CalculatorScreenEvents.Number(0))
                }
                CalculatorButton(
                    symbol = ".",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)) {
                    viewModel.onEvents(CalculatorScreenEvents.Decimal)
                }

                CalculatorButton(
                    symbol = "=",
                    color = MaterialTheme.colors.secondary,
                    textColor = MaterialTheme.colors.onSecondary,
                    modifier = modifier
                        .aspectRatio(2f)
                        .weight(2f)) {
                    // call the equate operation
                    viewModel.onEvents(CalculatorScreenEvents.Equate)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen()
}