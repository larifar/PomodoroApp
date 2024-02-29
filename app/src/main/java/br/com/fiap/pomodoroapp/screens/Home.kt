package br.com.fiap.pomodoroapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.pomodoroapp.R

@Composable
fun HomeScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAD4D7)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.pomodoro),
            contentDescription = "imagem de um pomodoro",
            modifier = Modifier
                .size(300.dp)
                .offset(y = (-20).dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "POMODORO",
            fontSize = 32.sp,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(12.dp))
        IconButton(onClick = {
            navController.navigate("timer")
        }) {
            Icon(
                painter = painterResource(id = R.drawable.play_vector),
                contentDescription = "vetor de play",
                modifier = Modifier
                    .size(55.dp)
            )
        }

    }
}
