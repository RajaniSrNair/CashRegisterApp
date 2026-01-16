package com.example.cashregisterapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cashregisterapp.viewmodel.CashRegisterViewModel

@Composable
fun CashRegisterScreen(
    viewModel: CashRegisterViewModel,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Cash Register",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductList(viewModel)

        Spacer(modifier = Modifier.height(16.dp))

        SelectedProductInfo(viewModel)

        Spacer(modifier = Modifier.height(16.dp))

        NumberPad(viewModel)

        Spacer(modifier = Modifier.height(16.dp))

        TotalAndPay(viewModel, navController)
    }
}
@Composable
fun ProductList(viewModel: CashRegisterViewModel) {
    Text(text = "Products")

    LazyColumn {
        items(viewModel.products.value) { product ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.selectProduct(product) }
                    .padding(8.dp)
            ) {
                Text(
                    text = "${product.name} - $${product.price} (Qty: ${product.quantityAvailable})"
                )
            }
        }
    }
}
@Composable
fun SelectedProductInfo(viewModel: CashRegisterViewModel) {
    val product = viewModel.selectedProduct.value

    if (product != null) {
        Text(text = "Selected Product:")
        Text(text = "Name: ${product.name}")
        Text(text = "Price: $${product.price}")
        Text(text = "Entered Quantity: ${viewModel.enteredQuantity.value}")
    } else {
        Text(text = "No product selected")
    }
}
@Composable
fun NumberPad(viewModel: CashRegisterViewModel) {
    val buttons = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf("C", "0")
    )

    Column {
        buttons.forEach { row ->
            Row {
                row.forEach { label ->
                    Button(
                        onClick = {
                            if (label == "C") {
                                viewModel.clearQuantity()
                            } else {
                                viewModel.addDigit(label)
                            }
                        },
                        modifier = Modifier
                            .padding(4.dp)
                            .weight(1f)
                    ) {
                        Text(text = label)
                    }
                }
            }
        }
    }
}
@Composable
fun TotalAndPay(
    viewModel: CashRegisterViewModel,
    navController: NavController
) {
    val total = viewModel.getTotal()

    Text(text = "Total: $${total}")

    Spacer(modifier = Modifier.height(8.dp))

    Button(
        onClick = {
            viewModel.pay()
            navController.navigate("history")
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Pay")
    }
}
