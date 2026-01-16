package com.example.cashregisterapp.model

data class Purchase(
    val productName: String,
    val quantity: Int,
    val totalPrice: Double,
    val timestamp: Long = System.currentTimeMillis()
)
