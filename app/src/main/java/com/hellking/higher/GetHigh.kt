package com.hellking.higher

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun GetHigh() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val highState = remember { mutableStateOf(false) }
        val item = remember {
            mutableStateOf(newHigh())
        }
        val context = LocalContext.current
        if (highState.value) {
            when (item.value) {
                "Bong" -> {
                    Image(
                        painter = painterResource(R.drawable.bong),
                        contentDescription = "Bong",
                        modifier = Modifier.size(240.dp)
                    )
                }
                "Chillum" -> {
                    Image(
                        painter = painterResource(id = R.drawable.chillum),
                        contentDescription = "Chillum",
                        modifier = Modifier
                            .size(240.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                else -> {
                    Image(
                        painter = painterResource(id = R.drawable.joint),
                        contentDescription = "Joint",
                        modifier = Modifier.size(240.dp)
                    )
                }
            }
            Toast.makeText(
                context,
                item.value,
                Toast.LENGTH_SHORT,
            ).show()
        }
        Spacer(modifier = Modifier.height(18.dp))
        Button(
            onClick = {
                highState.value = true;
                item.value = newHigh()
            }
        ) {
           Text(text = "Let's Bake") 
        }
    }
}


fun newHigh():String {
    val modes = listOf<String>("Bong", "Chillum", "Joint")
    return modes.random().toString()
}