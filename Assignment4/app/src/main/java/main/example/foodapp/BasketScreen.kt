package main.example.foodapp

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun BasketScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Basket",
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

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                contentPadding = PaddingValues(
                    top = 10.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = 70.dp
                ),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(BasketDetails.basket.items) { item ->
                    CreateBasketCards(item = item)
                }
            }

            Spacer(Modifier.padding(20.dp))

            Text(
                text = "Total:    ${BasketDetails.basket.total.value}"
            )

            Spacer(Modifier.padding(30.dp))

            Button(
                onClick = {}
            ) {
                Text("Place order")
            }
        }
    }
}

@Composable
fun CreateBasketCards(item: ItemDetails) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .requiredHeight(100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = item.title
            )

            Text(
                text = item.selected.value.toString()
            )

            Text(
                text = (item.selected.value * item.price).toString()
            )
        }
    }
}
