package main.example.foodapp

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Button( onClick = { navController.navigate(route = Screens.Menu.route) }) {
        Text("Next")
    }
}