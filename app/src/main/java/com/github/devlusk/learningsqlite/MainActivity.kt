package com.github.devlusk.learningsqlite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.devlusk.learningsqlite.composable.ValidatedTextField
import com.github.devlusk.learningsqlite.ui.theme.LearningSQLiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningSQLiteTheme {
                InputScreen()
            }
        }
    }
}

@Composable
fun InputScreen(modifier: Modifier = Modifier) {
    val (firstName, setFirstName) = remember { mutableStateOf("") }
    val (lastName, setLastName) = remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .fillMaxSize()
        ) {
            ValidatedTextField(
                value = firstName,
                onValueChange = setFirstName,
                label = "First name",
                placeholder = "e.g: Lucas",
                context = context
            )

            Spacer(modifier = Modifier.height(10.dp))

            ValidatedTextField(
                value = lastName,
                onValueChange = setLastName,
                label = "Last Name",
                placeholder = "e.g: Silva",
                context = context
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {},
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Save",
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun InputScreenPreview() {
    LearningSQLiteTheme {
        InputScreen()
    }
}