package com.github.devlusk.learningsqlite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("First Name") },
                placeholder = { Text("e.g: Lucas") },
                modifier = Modifier.fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Last Name") },
                placeholder = { Text("e.g: Lucas") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {},
                shape = RoundedCornerShape(30),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("SAVE")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun InputScreenPreview() {
    InputScreen()
}