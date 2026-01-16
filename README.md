# CashRegisterApp

## Description
CashRegisterApp is a small Android application built using **Kotlin**, **Jetpack Compose**, **Navigation-Compose**, and the **MVVM architecture**.  
The app allows users to select products, enter quantities, add multiple products to a cart, and complete purchases. All completed transactions are stored and displayed in a **Purchase History** screen.

This project demonstrates:
- Multi-screen navigation with **Navigation-Compose**
- State management using **ViewModel**
- User interface design using **Jetpack Compose**
- MVVM architecture best practices

---

## Features
- **Product Selection:** Choose from a list of products with name, price, and available quantity.
- **Quantity Input:** Enter quantities using an on-screen number pad.
- **Total Calculation:** Automatic total price calculation for selected items.
- **Payment:** Complete purchase and update inventory quantities.
- **Purchase History:** View all completed purchases, including product, quantity, total amount, and timestamp.
- **Dynamic UI Updates:** UI updates automatically with cart changes and new purchases.
- **Single-Activity Architecture:** Navigation between screens is handled using Navigation-Compose.

---

## Demo Video
Video of the MVVM demonstration: https://youtu.be/jtj1JOPzzv0

Video of screen recording (emulator): https://youtube.com/shorts/T-gbYrXbF7w?feature=share

---

## Project Structure
- `models/` – Data models for **Product**, **Purchase**, and **CartItem**
- `viewmodel/` – `CashRegisterViewModel` managing app state
- `ui/` – Jetpack Compose screens:
  - `CashRegisterScreen.kt` – Main screen for selecting products and adding to cart
  - `HistoryScreen.kt` – Displays purchase history
  - `NavGraph.kt` – Navigation graph defining screen transitions
- `theme/` – App theme and styling
- `MainActivity.kt` – Entry point of the app

---

## Usage
1. Clone the repository to your local machine.
2. Open the project in **Android Studio**.
3. Build and run the app on an emulator or Android device.
4. On the **Cash Register Screen**:
   - Select a product.
   - Enter the quantity using the number pad.
   - Tap **Add to Cart** to include multiple products.
5. Tap **Pay All** to complete the purchase.
6. View all purchases on the **Purchase History Screen**.

---

## Screenshots
*(Optional: Add screenshots of your app running on an emulator or device here)*

---

## Dependencies
- Kotlin 1.8+
- Jetpack Compose 1.5+
- Navigation-Compose
- Material3
- AndroidX ViewModel

---

## Author
**Rajani Sr Nair**

---

