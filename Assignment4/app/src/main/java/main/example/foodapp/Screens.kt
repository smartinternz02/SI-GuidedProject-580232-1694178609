package main.example.foodapp

sealed class Screens(val route: String) {
    object Login: Screens(route = "login")
    object Signup: Screens(route = "signup")
    //object Home: Screens(route = "home")
    object Menu: Screens(route = "menu")
    object Food: Screens(route = "food")
    object Basket: Screens(route = "basket")
}
