package com.example.todoapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = "Welcome"
        )
        Text(
            text = "this is a To do task app"
        )
        Button(
            onClick = {
                navController.navigate("login")

            }
        ){
            Text(text = "iniciar sesion")
        }
        Button(
            onClick = {
                navController.navigate("signup")
            }

        ) {
            Text(text = "crear cuenta")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {

    val navController = rememberNavController()

    WelcomeScreen(navController = navController)
}

