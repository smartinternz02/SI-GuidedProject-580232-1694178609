package main.example.composefirst
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewFunc()
        }
    }
}


@Preview(name = "First", showSystemUi = true)
@Composable
fun PreviewFunc() {
    Column(modifier = Modifier
        .background(color = Color(0xff787a7b))
        .fillMaxSize()
    ) {
        val showOptions = remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .background(color = Color(0xff787a7b))
                .width(600.dp)
                .height(500.dp)
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.contact),
                contentDescription = "Contact Icon",
                modifier = Modifier
                    .border(width = 2.dp, color = Color(0xFF1d2022)),
                colorFilter = ColorFilter.tint(Color(0xFF1d2022)),
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Text(
                text = "Login",
                color = Color(0xFFDFE1E2),
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.padding(15.dp))

            val username = remember { mutableStateOf("") }
            TextField(value = username.value,
                onValueChange = { username.value = it },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xff494c4e),
                    textColor = Color(0xffdfe1e2)
                ),
                placeholder = { Text("Username", color = Color(0xffcecdf0)) }
            )

            Spacer(modifier = Modifier.padding(10.dp))

            val password = remember { mutableStateOf("") }
            val passwordVisibility: Boolean by remember { mutableStateOf(false) }
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xff494c4e),
                    textColor = Color(0xffdfe1e2)
                ),
                placeholder = { Text("Password", color = Color(0xffcecdf0)) },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            )

            Spacer(modifier = Modifier.padding(15.dp))

            Button(
                onClick = { showOptions.value = true },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xff1d2022),
                    contentColor = Color(0xffdfe1e2)
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(100.dp)
            ) {
                Text("Proceed")
            }
        }

        //-------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------

        val context = LocalContext.current
        if (showOptions.value) {
            Column(
                modifier = Modifier
                    .background(color = Color(0xff787a7b))
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(
                        onClick = {
                            val url = "https://www.amazon.com/"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                            context.startActivity(intent)
                            },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xffdfe1e2),
                            contentColor = Color(0xff1d2022)
                        ),
                        modifier = Modifier
                            .height(50.dp)
                            .width(130.dp)
                    ) {
                        Image(painter = painterResource(R.drawable.amazon),
                            contentDescription = "amazon icon",
                            modifier = Modifier
                                .height(22.dp)
                        )
                        Text("Amazon")
                    }

                    Spacer(modifier = Modifier.width(60.dp))

                    Button(
                        onClick = {
                            val url = "https://login.microsoftonline.com/"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                            context.startActivity(intent)
                            },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xffdfe1e2),
                            contentColor = Color(0xff1d2022)
                        ),
                        modifier = Modifier
                            .height(50.dp)
                            .width(130.dp)
                    ) {
                        Image(painter = painterResource(R.drawable.microsoft),
                            contentDescription = "microsoft icon",
                            modifier = Modifier
                                .height(20.dp)
                        )
                        Text("Microsoft")
                    }
                }

                Spacer(modifier = Modifier.padding(15.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            val url = "https://github.com/login"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                            context.startActivity(intent)
                            },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xffdfe1e2),
                            contentColor = Color(0xff1d2022)
                        ),
                        modifier = Modifier
                            .height(50.dp)
                            .width(130.dp)
                    ) {
                        Image(painter = painterResource(R.drawable.github),
                            contentDescription = "github icon",
                            modifier = Modifier
                                .height(20.dp)
                        )
                        Text("Github")
                    }

                    Spacer(modifier = Modifier.width(60.dp))

                    Button(
                        onClick = {
                            val url = "https://www.linkedin.com/login"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                            context.startActivity(intent)
                            /*
                            if (intent.resolveActivity(context.packageManager) != null)
                                context.startActivity(intent)
                            else
                                Toast.makeText(context, "No web browser available!", Toast.LENGTH_LONG).show()
                            */
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xffdfe1e2),
                            contentColor = Color(0xff1d2022)
                        ),
                        modifier = Modifier
                            .height(50.dp)
                            .width(130.dp)
                    ) {
                        Image(painter = painterResource(R.drawable.linkedin),
                            contentDescription = "linkedin icon"
                        )
                        Text("LinkedIn")
                    }
                }
            }
        }
    }
}


