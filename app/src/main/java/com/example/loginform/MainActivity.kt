package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginform.ui.components.OutlinedTextFieldWithTrailingIcon
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginFormTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginForm(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column (
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(all = 16.dp)
    ){
        // I'm creating the Base UI Component Here
        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            label = { Text("Username")},
            placeholder = { Text("Enter your username")},

            modifier = Modifier.fillMaxWidth(),

            trailingIcon = {
                Icon(
                    imageVector =  Icons.Filled.Email,
                    contentDescription = "Email Icon"
                )
            },

            visualTransformation = VisualTransformation.None

        )

        // This is reusable component
        OutlinedTextFieldWithTrailingIcon(
            password,
            onValueChangeFunc = {password=it},
            "Password",
            "Enter your password",
            Icons.Filled.Lock,
            "Lock icon",
            true
        )

        // Let's add an button and set an click handelr function
        Button(onClick = {
            clickHandler(username,password)},
            modifier= Modifier.padding(top=16.dp)
        ) { Text("Click to View in LogCat")}


    }

}


// Click handler function for the button
fun clickHandler(usernameValue:String, passwordValue:String) {

    if (usernameValue.isEmpty() || passwordValue.isEmpty()) {
        //Can view the result using LogCat
        println("Username or password cannot be empty")
    } else {
        //Can view the result using LogCat
        println("Username: $usernameValue")
        println("Password: $passwordValue")
    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginFormTheme {
        LoginForm()
    }
}