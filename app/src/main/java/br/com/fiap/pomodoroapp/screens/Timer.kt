package br.com.fiap.pomodoroapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.pomodoroapp.R
import br.com.fiap.pomodoroapp.util.mudarIcone
import br.com.fiap.pomodoroapp.util.transformarTempo
import kotlinx.coroutines.delay

@Composable
fun TimerScreen() {
    var tempo by remember {
        mutableStateOf(60*25)
    }

    var play by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(play) {
        if (play) {
            while (tempo > 0) {
                delay(1000) // Aguarda 1 segundo
                tempo -= 1
            }
            if (tempo==0){
                play = false
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAD4D7)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .height(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Estudando",
                fontSize = 32.sp,
                color = Color(0xF7E9E7E0),
                fontFamily = FontFamily.Serif
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    tempo += 30
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_drop_up),
                        contentDescription = "flecha para cima",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }

                Text(
                    text = transformarTempo(tempo),
                    fontSize = 70.sp
                )

                IconButton(onClick = {
                    tempo-=30
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_drop_down_24),
                        contentDescription = "flecha para baixo",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }

            }

        }
        Row {
            IconButton(onClick = {
                play = !play
            }) {
                Icon(
                    painter = painterResource(id = mudarIcone(play)),
                    contentDescription = "vetor de play",
                    modifier = Modifier
                        .size(55.dp)
                )
            }

        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TimerPreview() {
    TimerScreen()
}