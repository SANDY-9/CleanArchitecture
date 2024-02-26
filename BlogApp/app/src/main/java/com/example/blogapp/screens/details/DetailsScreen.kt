package com.example.blogapp.screens.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.blogapp.screens.home.PostItem

@Composable
fun DetailsScreen(detailsViewModel: DetailsViewModel = hiltViewModel()) {

    val res = detailsViewModel.details.value

    if(res.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
    
    if(res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = res.error, modifier = Modifier.align(Alignment.Center))
        }
    }
    
    res.data?.let {
        Column(modifier = Modifier) {
            PostItem(blog = it, l = {})
            Text(text = it.likes.toString() + " Likes", modifier = Modifier.padding(12.dp))
            it.tags?.forEach { tag ->
                TagItem(tag = tag)
            }
        }
    }
    
}

@Composable
fun TagItem(tag: String) {
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(8.dp),
        shape = RoundedCornerShape(40.dp),
        border = BorderStroke(0.5.dp, color = Color.Gray)
    ) {
        Text(
            text = tag,
            style = TextStyle(color = Color.Black),
            modifier = Modifier.padding(12.dp)
        )
    }
}