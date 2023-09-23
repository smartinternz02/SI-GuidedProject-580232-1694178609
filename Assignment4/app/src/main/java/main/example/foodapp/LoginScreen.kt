package main.example.foodapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.net.ConnectException


@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.food1),
                contentDescription = "foodBG1",
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.padding(15.dp))

        Text(
            text = "Foodmandu",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h2.fontSize,
            fontFamily = FontFamily(Font(R.font.cheesecake))
        )

        Spacer(modifier = Modifier.padding(20.dp))

        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it},
            label = { Text("Username" )}
        )

        Spacer(modifier = Modifier.padding(10.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it},
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(20.dp))

        FloatingActionButton(
            onClick = { navController.navigate(route = Screens.Menu.route) },
            modifier = Modifier.width(120.dp)
        ) {
            Text(text = "Proceed")
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = "Create account",
            color = Color.Blue,
            fontSize = 15.sp,
            modifier = Modifier.clickable {
                navController.navigate(route = Screens.Signup.route)
            }
        )

        Spacer(modifier = Modifier.padding(50.dp))

        Image(
            painter = painterResource(id = R.drawable.food4),
            contentDescription = "foodBG2",
            modifier = Modifier
                .requiredHeight(175.dp)
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreenLogin() {
    LoginScreen(
        navController = rememberNavController()
    )
}