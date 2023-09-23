package main.example.foodapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import main.example.foodapp.ui.theme.Shapes


@Composable
fun MenuScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Menu",
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 70.dp)

            //verticalArrangement = Arrangement.Top,
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Offers",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Spacer(modifier = Modifier.padding(2.dp))

            LazyRow(
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(5.dp),

            ) {
                items(GetOffers()) { item: MenuList ->
                    CreateCardsRow(img = item.img, title = item.title)
                }
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = "Menu",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Spacer(modifier = Modifier.padding(2.dp))

            LazyColumn(
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                ),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                items(GetMenu()) { item: MenuList ->
                    CreateCardsColumn(img = item.img, title = item.title, route = item.route, navController = navController)
                }
            }
        }
    }
}

@Composable
fun CreateCardsRow(img: Int, title: String) {
    Card(
       elevation = 8.dp,
       modifier = Modifier
           .padding(8.dp)
           .requiredWidth(180.dp)
           .requiredHeight(100.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier
                    .requiredWidth(60.dp)
                    .requiredHeight(50.dp)
            )

            Text(
                text = title,
                fontSize = MaterialTheme.typography.body1.fontSize,
                style = MaterialTheme.typography.body1
            )
        }
    }
}


@Composable
fun CreateCardsColumn(img: Int, title: String, route: String, navController: NavController) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .requiredHeight(100.dp)
            .clickable {
                navController.navigate(route = "$route/$title")
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier
                    .requiredWidth(60.dp)
                    .requiredHeight(50.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = title,
                fontSize = MaterialTheme.typography.body1.fontSize,
                style = MaterialTheme.typography.body1
            )

            //Spacer(modifier = Modifier.width(120.dp))
        }
    }
}

fun GetMenu(): MutableList<MenuList> {
    val menu = mutableListOf<MenuList>()
    menu.add(MenuList(R.drawable.momo, "Momo"))
    menu.add(MenuList(R.drawable.pizza, "Pizza"))
    menu.add(MenuList(R.drawable.burger, "Burger"))
    menu.add(MenuList(R.drawable.sandwich, "Sandwich"))
    menu.add(MenuList(R.drawable.roll, "Roll"))

    return menu
}


fun GetOffers(): MutableList<MenuList> {
    val offers = mutableListOf<MenuList>()

    offers.add(MenuList(R.drawable.discount, "50% OFF Wednesday"))
    offers.add(MenuList(R.drawable.cashback,"Use this code for Rs. 20 cashback!"))
    offers.add(MenuList(R.drawable.deal, "Special Deal! Chicken pizza + Burger combo only at Rs. 499!"))

    return offers
}


@Preview(showBackground = true)
@Composable
fun PreviewFunc() {
    MenuScreen(navController = rememberNavController())
}