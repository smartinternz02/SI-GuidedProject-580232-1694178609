package main.example.foodapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun FoodScreen(foodName: String? = null, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = foodName!!,
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontFamily = FontFamily(Font(R.font.cheesecake)),
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                )
            },
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .requiredHeight(70.dp)
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .requiredHeight(70.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.clickable {
                            navController.navigate(route = "basket")
                        }
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = BasketDetails.basket.itemCount.value.toString()
                    )
                }
            }
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                top = 10.dp,
                start = 10.dp,
                end = 10.dp
            ),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(ItemList(foodName!!)) { item ->
                CreateItemListCard(item)
            }
        }
    }
}

fun ItemList(foodName: String): MutableList<ItemDetails> {
    val foodItems = mutableListOf<ItemDetails>()

    foodItems.add(ItemDetails(title = "Chicken $foodName", price = 200))
    foodItems.add(ItemDetails(title = "Veg $foodName", price = 180))
    foodItems.add(ItemDetails(title = "Pork $foodName", price = 210))
    foodItems.add(ItemDetails(title = "Special $foodName", price = 250))

    return foodItems
}


@Composable
fun CreateItemListCard(item: ItemDetails) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .requiredHeight(100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            Column() {
                Text(
                    text = item.title,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    textAlign = TextAlign.Left,
                )

                Spacer(Modifier.padding(3.dp))

                Text(
                    text = "Rs. ${item.price}",
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.padding(horizontal = 15.dp)
        ) {

            Button(
                onClick = {
                    if (item.selected.value != 0) {
                        item.selected.value--
                        BasketDetails.basket.total.value -= item.price
                    }

                    if (item.selected.value == 0 && BasketDetails.basket.itemCount.value > 0) {
                        BasketDetails.basket.itemCount.value--
                        BasketDetails.basket.items.remove(item)
                    }
                },

                border = BorderStroke(1.dp, Color.Red),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
                modifier = Modifier
                    .width(40.dp)
            ) {
                Text("-")
            }

            Spacer(Modifier.width(3.dp))

            Text(
                text = item.selected.value.toString(),
                style = MaterialTheme.typography.body1
            )

            Spacer(Modifier.width(3.dp))

            val clickedAdd = remember { mutableStateOf(false) }
            Button(
                onClick = {
                    if (!clickedAdd.value || item.selected.value == 0) {
                        BasketDetails.basket.itemCount.value++
                        BasketDetails.basket.items.add(item)
                        clickedAdd.value = true
                    }

                    item.selected.value++
                    BasketDetails.basket.total.value += item.price
                },
                border = BorderStroke(1.dp, Color.Red),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
                modifier = Modifier.width(40.dp)
            ) {
                Text("+")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewFoodScreen() {
    FoodScreen("", navController = rememberNavController())
}
