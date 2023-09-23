package main.example.foodapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    ) {
        composable(route = Screens.Login.route)
        {
            LoginScreen(navController = navController)
        }

        composable(route = Screens.Signup.route)
        {
            SignupScreen(navController = navController)
        }

        /*
        composable(route = Screens.Home.route)
        {
            HomeScreen(navController)
        }
         */

        composable(route = Screens.Menu.route)
        {
            MenuScreen(navController)
        }

        composable(route = "${Screens.Food.route}/{foodName}")
        {
            val foodName = it.arguments?.getString("foodName")
            FoodScreen(foodName = foodName, navController = navController)
        }

        composable(route = "basket")
        {
            BasketScreen()
        }

        /*composable(route = Screens.Momo.route)
        {
            MomoScreen()
        }

        composable(route = Screens.Burger.route)
        {
            BurgerScreen()
        }

        composable(route = Screens.Pizza.route)
        {
            PizzaScreen()
        }

        composable(route = Screens.Sandwich.route)
        {
            SandwichScreen()
        }

        composable(route = Screens.Roll.route)
        {
            RollScreen()
        }*/
    }
}