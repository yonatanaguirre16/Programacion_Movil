package com.example.todoapp.screens


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.components.Contact


@Composable
fun MainScreen(navController: NavController) {

    val contacts = listOf( Pair(first = "Yonatan", second = "123456789"))

    val contactList = remember { mutableStateListOf<Pair<String, String>>() }

    LazyColumn {
        items(items = contacts){
            contact ->
            Contact(name = contact.first, phone = contact.second)

            contactList.add(Pair(contact.first, contact.second))

        }
    }



}



@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}
