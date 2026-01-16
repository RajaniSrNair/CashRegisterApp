package com.example.cashregisterapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cashregisterapp.viewmodel.CashRegisterViewModel

@Composable
fun HistoryScreen(viewModel: CashRegisterViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Purchase History",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (viewModel.purchaseHistory.value.isEmpty()) {
            Text(text = "No purchases yet")
        } else {
            LazyColumn {
                items(viewModel.purchaseHistory.value) { purchase ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "Product: ${purchase.productName}")
                            Text(text = "Quantity: ${purchase.quantity}")
                            Text(text = "Total: $${purchase.totalPrice}")
                        }
                    }
                }
            }
        }
    }
}
