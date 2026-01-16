package com.example.cashregisterapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cashregisterapp.viewmodel.CashRegisterViewModel

@Composable
fun AppNavGraph(viewModel: CashRegisterViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "cash"
    ) {
        composable("cash") {
            CashRegisterScreen(viewModel, navController)
        }

        composable("history") {
            HistoryScreen(viewModel)
        }
    }
}
