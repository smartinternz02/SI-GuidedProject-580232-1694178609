package main.example.foodapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuList(
    val img: Int,
    val title: String,
    val route: String = "food"
)

data class ItemDetails(
    val title: String,
    val price: Int,
    var selected: MutableState<Int> = mutableStateOf(0)
)

sealed class BasketDetails(
    var itemCount: MutableState<Int> = mutableStateOf(0),
    val items: MutableList<ItemDetails> = mutableListOf<ItemDetails>(),
    var total: MutableState<Int> = mutableStateOf(0)
) {
    object basket: BasketDetails()
}
