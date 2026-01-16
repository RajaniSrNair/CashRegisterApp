package com.example.cashregisterapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cashregisterapp.model.Product
import com.example.cashregisterapp.model.Purchase

class CashRegisterViewModel : ViewModel() {

    // List of products
    val products = mutableStateOf(
        listOf(
            Product("Apple", 2.0, 20),
            Product("Banana", 1.5, 30),
            Product("Orange", 3.0, 15)
        )
    )

    // Currently selected product
    val selectedProduct = mutableStateOf<Product?>(null)

    // Quantity typed using number pad
    val enteredQuantity = mutableStateOf("")

    // Purchase history list
    val purchaseHistory = mutableStateOf(listOf<Purchase>())

    // When user taps a product
    fun selectProduct(product: Product) {
        selectedProduct.value = product
        enteredQuantity.value = ""
    }

    // When user presses a number
    fun addDigit(digit: String) {
        enteredQuantity.value += digit
    }

    // Clear quantity
    fun clearQuantity() {
        enteredQuantity.value = ""
    }

    // Calculate total price
    fun getTotal(): Double {
        val quantity = enteredQuantity.value.toIntOrNull() ?: 0
        val price = selectedProduct.value?.price ?: 0.0
        return quantity * price
    }

    // When Pay button is clicked
    fun pay() {
        val product = selectedProduct.value ?: return
        val quantity = enteredQuantity.value.toIntOrNull() ?: return

        if (quantity <= 0 || quantity > product.quantityAvailable) return

        val purchase = Purchase(
            productName = product.name,
            quantity = quantity,
            totalPrice = quantity * product.price
        )

        purchaseHistory.value = purchaseHistory.value + purchase
        product.quantityAvailable -= quantity
        enteredQuantity.value = ""
    }
}
