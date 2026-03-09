package com.example.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todoapp.screens.LoginScreen
import com.example.todoapp.screens.MainScreen
import com.example.todoapp.screens.WelcomeScreen
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.screens.SignUpScreen


@Composable
fun AppNavigation(navController: NavHostController){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ){
        composable("welcome"){
            WelcomeScreen(navController)
        }
        composable("login"){
            LoginScreen(navController)
        }
        composable("signup"){
            SignUpScreen(navController)
        }
        composable("main"){
            MainScreen(navController)
        }

    }
}