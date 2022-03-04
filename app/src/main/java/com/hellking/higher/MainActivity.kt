package com.hellking.higher

import android.content.Context
import android.icu.text.CaseMap
import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hellking.higher.ui.theme.HigherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HigherTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.White) {
                    val context: Context = applicationContext
                    val item = high()
                    Column {
                        TopBar()
                        Spacer(Modifier.height(8.dp))
                        GetHigh()
                    }
                }
            }
        }
    }
}

//@Composable
//fun high(): String {
//    val modes = listOf<String>("Bong", "Chillum", "Joint")
//    val previousMode = remember {
//        mutableStateOf("")
//    }
//    var newMode = modes.random().toString()
//    while (newMode == previousMode.value) {
//        newMode = modes.random().toString()
//    }
//    previousMode.value = newMode
//    return newMode
//}

fun high(): String {
    val modes = listOf<String>("Bong", "Chillum", "Joint")
    return modes.shuffled().first()
    //return modes.random().toString()
}


// TODO
// Change font
// Add Emojis
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Higher",
                color = Color.Black,
                fontSize = 32.sp
            )},
        backgroundColor = Color.White
    )
}

@Composable
fun Panda() { // wow, awesome name, ikr
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val toSmoke = remember { mutableStateOf(high()) }
        val openDialog = remember{ mutableStateOf(false) }
        Button(onClick = {
            openDialog.value = true;
            toSmoke.value = high()
        }) {
            Text(text = "Click me")
        }
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(text = "It's time for")
                },
                text = {
                    Text(text = toSmoke.value)
                },
                confirmButton = {
                },
                dismissButton = {
                    Button(onClick = {
                        openDialog.value = false;
                        toSmoke.value = high()
                    }) {
                        Text(text = "Close")
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    TopBar()
}