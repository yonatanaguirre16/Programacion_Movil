package com.example.todoapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.components.Contact

@Composable
fun MainScreen(navController: NavController) {

    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    
    val contactList = remember {
        mutableStateListOf<Pair<String, String>>(
            Pair("Yonatan", "123456789"),
            Pair("Juan", "987654321"),
            Pair("Pedro", "555555555")
        ) 
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Name", fontSize = 18.sp)
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Phone", fontSize = 18.sp)
        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter phone") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    if (nombre.isNotBlank() && telefono.isNotBlank()) {
                        contactList.add(Pair(nombre, telefono))
                        nombre = ""
                        telefono = ""
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Add contact")
            }
            
            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (contactList.isNotEmpty()) {
                        contactList.removeAt(contactList.size - 1)
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Delete")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(contactList) { contact ->
                Contact(name = contact.first, phone = contact.second)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}
