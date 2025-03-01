package com.github.devlusk.learningsqlite.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.devlusk.learningsqlite.domain.Member

@Composable
fun DataList(list: List<Member>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray.copy(.2f), RoundedCornerShape(5.dp))
            .padding(16.dp)
    ) {
        items(list) { item ->
            Column(
                modifier = Modifier
                    .padding(vertical = 8.dp) // Space between the items
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .padding(16.dp), // Internal padding
            ) {
                Text(
                    text = "Member: ${item.firstName} ${item.lastName}",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DataListPreview() {
    DataList(
        list = listOf(
            Member(firstName = "Lucas", lastName = "Silva"),
            Member(firstName = "Carlos", lastName = "Oliveira")
        )
    )
}
