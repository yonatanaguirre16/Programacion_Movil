package com.example.todoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignUpScreen(navController: NavHostController, modifier: Modifier = Modifier) {

    // ESTADO

    var nombre by remember { mutableStateOf("") }
    var nombreError by remember { mutableStateOf(false) }

    var email by remember { mutableStateOf("") }
    var mailError by remember { mutableStateOf(false) }

    var telefono by remember { mutableStateOf("") }
    var telError by remember { mutableStateOf(false) }

    var pass by remember { mutableStateOf("") }
    var passError by remember { mutableStateOf(false) }


    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF5E4AE3)),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xFFFFFFFF))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Crear Cuenta", fontSize = 30.sp)

            Spacer(modifier = Modifier.height(20.dp))

            // FIELD NOMBRE
            OutlinedTextField(
                value = nombre,
                onValueChange = {
                    if (it.all { char -> char.isLetter()}) {
                        nombre = it
                        nombreError = it.isBlank()
                    }
                },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth(),
                isError = nombreError,
                supportingText = {
                    if (nombreError) {
                        Text("El nombre solo debe contener letras")
                    }
                },
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            // FIELD EMAIL
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    mailError = !isValidEmail(email = it)
                },
                label = { Text("Correo") },
                isError = mailError,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // FIELD TELEFONO
            OutlinedTextField(
                value = telefono,
                onValueChange = {
                    if (it.all { char -> char.isDigit() }) {
                        telefono = it
                    }
                },
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // FIELD PASS
            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // FIELD CONFIRM PASS
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Confirmar Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    navController.navigate("welcome")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign Up")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUpScreen(rememberNavController())
}