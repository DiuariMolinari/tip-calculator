package com.senac.tipcalculator


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly
import com.senac.tipcalculator.Components.SliderComponent
import com.senac.tipcalculator.ui.theme.TipCalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                TipCalculatorTheme {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    var valor by remember {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {

        Row() {
            Text(text = "Amount", style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(all = 25.dp))
            OutlinedTextField(value = "", onValueChange = { "tryNumberState.value = it "}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        }

        Row() {
            Text(text = "Custom %", style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(all = 25.dp))
            SliderComponent(valor, onValorChange = { valor = it })
            MostrarValor(valor)
        }

        Row() {
            Text(text = "15%", style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 10.dp, top = 25.dp))
            Text(text = "25%", style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(start = 90.dp, end = 20.dp, bottom = 10.dp, top = 25.dp))
        }
        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Tip", style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(start = 30.dp, top = 10.dp, bottom = 10.dp, end = 45.dp))
            Text(text = "$ 0.00", style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(start = 1.dp, top = 10.dp, bottom = 10.dp, end = 35.dp))
            Text(text = "$ 0.00", style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(start = 60.dp, top = 10.dp, bottom = 10.dp, end = 1.dp))
        }

        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Total", style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(start = 30.dp, top = 10.dp, bottom = 10.dp, end = 30.dp))
            Text(text = "$ 0.00", style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(start = 1.dp, top = 10.dp, bottom = 10.dp, end = 1.dp))
            Text(text = "$ 0.00", style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(start = 95.dp, top = 10.dp, bottom = 10.dp, end = 10.dp))
        }
    }
}

@Composable
fun MostrarValor(valor: Int) {
    //val df = DecimalFormat("0.00")
    //Text(text = "${df.format(valor)}", style = MaterialTheme.typography.subtitle1)
    Text(text = "${valor}", style = MaterialTheme.typography.subtitle1)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorTheme {
        MyApp()
    }
}