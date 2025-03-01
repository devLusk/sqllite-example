package com.github.devlusk.learningsqlite.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.devlusk.learningsqlite.domain.Member

@Composable
fun DataList(list: List<Member>) {
    LazyColumn {
        items(list) { item ->
            Text(text = "${item.firstName} ${item.lastName}")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DataListPreview() {
    DataList(
        list = listOf(
            Member(firstName = "Lucas", lastName = "Silva"),
            Member(firstName = "Lucas", lastName = "Silva"),
        )
    )
}