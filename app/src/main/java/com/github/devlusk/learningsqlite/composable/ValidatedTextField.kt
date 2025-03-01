package com.github.devlusk.learningsqlite.composable

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ValidatedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    context: android.content.Context
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.all { it.isLetter() }) {
                onValueChange(newValue)
            } else {
                Toast.makeText(
                    context,
                    "Error: Unsupported character entered.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        },
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}