package com.senac.tipcalculator.Components

import androidx.compose.material.Slider
import androidx.compose.runtime.Composable


@Composable
fun SliderComponent(valor: Int, onValorChange: (Int) -> Unit) {
    Slider(
        value = valor.toFloat(),
        onValueChange = { onValorChange( it.toInt() ) },
        valueRange = 1f..30f,
        steps = 2
    )

}