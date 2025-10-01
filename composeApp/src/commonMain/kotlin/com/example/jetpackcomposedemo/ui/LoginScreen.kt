package com.example.jetpackcomposedemo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import floragogo.composeapp.generated.resources.Res
import floragogo.composeapp.generated.resources.app_logo
import floragogo.composeapp.generated.resources.ic_facebook
import floragogo.composeapp.generated.resources.ic_google_plus
import floragogo.composeapp.generated.resources.ic_twitter
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // App Logo
        Image(
            painter = painterResource(Res.drawable.app_logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Email TextField
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Username or Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (passwordVisible) Icons.Default.Visibility
                else Icons.Default.VisibilityOff
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(icon, contentDescription = "Toggle Password")
                }
            },
            keyboardOptions = KeyboardOptions.Default
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Login Button
        Button(
            onClick = onLoginSuccess,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A1B9A))
        ) {
            Text("Login", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Forgot Password
        TextButton(onClick = { /*TODO*/ }) {
            Text("Forgot Password?", color = Color(0xFF6A1B9A))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sign Up Row
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Don't have an account?", fontSize = 16.sp)
            TextButton(onClick = { /*TODO Navigate to Register */ }) {
                Text("Sign Up", color = Color(0xFF6A1B9A), fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Divider with OR
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(modifier = Modifier.weight(1f))
            Text("  OR  ", color = Color.Gray)
            Divider(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Social Login Buttons
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(Res.drawable.ic_facebook),
                    contentDescription = "Facebook",
                    modifier = Modifier.size(48.dp)
                )
            }
            Spacer(Modifier.width(24.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(Res.drawable.ic_google_plus),
                    contentDescription = "Google",
                    modifier = Modifier.size(48.dp)
                )
            }
            Spacer(Modifier.width(24.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(Res.drawable.ic_twitter),
                    contentDescription = "Twitter",
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}
