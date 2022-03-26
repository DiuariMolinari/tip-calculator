package com.senac.tipcalculator.Components

import androidx.compose.material.Slider
import androidx.compose.runtime.Composable


@Composable
fun SliderComponent(valor: Int, onValorChange: (Int) -> Unit) {
    Slider(
        value = valor.toFloat(),
        onValueChange = { onValorChange( it.toInt() ) },
        valueRange = 0f..100f,
        steps = 5
    )

}