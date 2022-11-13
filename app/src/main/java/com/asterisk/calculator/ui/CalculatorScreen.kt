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

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
) {

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
                text = "0",
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
                    modifier = modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    // clear result
                }
                CalculatorButton(
                    symbol = "Del",
                    color = MaterialTheme.colors.secondary,
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    // delete the last item on the screen
                }
                CalculatorButton(symbol = "/", modifier = modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                    // call the division operation
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

                }
                CalculatorButton(
                    symbol = "8",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {

                }
                CalculatorButton(symbol = "9", modifier = modifier
                    .aspectRatio(1f)
                    .weight(1f)) {

                }

                CalculatorButton(symbol = "x", modifier = modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                    // call the multiplication operation
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

                }
                CalculatorButton(
                    symbol = "5",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {

                }
                CalculatorButton(symbol = "6", modifier = modifier
                    .aspectRatio(1f)
                    .weight(1f)) {

                }

                CalculatorButton(symbol = "-", modifier = modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                    // call the subtraction operation
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

                }
                CalculatorButton(
                    symbol = "2",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {

                }
                CalculatorButton(
                    symbol = "3",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)) {
                }

                CalculatorButton(
                    symbol = "+",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)) {
                    // call the addition operation
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

                }
                CalculatorButton(
                    symbol = ".",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)) {
                }

                CalculatorButton(
                    symbol = "=",
                    color = MaterialTheme.colors.secondary,
                    modifier = modifier
                        .aspectRatio(2f)
                        .weight(2f)) {
                    // call the equate operation
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