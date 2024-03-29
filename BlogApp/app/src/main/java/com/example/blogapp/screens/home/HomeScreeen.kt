package com.example.blogapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberImagePainter
import com.example.domain.model.Blog

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {

    /*val res = viewModel.blogs.value

    if(res.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if(res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = res.error.toString(), modifier = Modifier.align(Alignment.Center))
        }
    }*/

    val list = viewModel.pager.collectAsLazyPagingItems()

    LazyColumn {
        /*res.data?.let {
            items(it) { blog ->
                PostItem(blog)
            }
        }*/
        items(list.itemCount) { index ->
            PostItem(list[index]!!) {
                navController.navigate("details/$it")
            }
        }
    }

}

@Composable
fun PostItem(blog: Blog, l:(String)-> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .clickable { l.invoke(blog.id) },
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CircularImage(width = 50.0, height = 50.0, radius = 25.0, imageUrl = blog.owner.picture)

            Spacer(modifier = Modifier.width(6.dp))

            Text(text = "${blog.owner.firstName} ${blog.owner.lastName}")

        }

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = rememberImagePainter(data = blog.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            text = blog.text,
            modifier = Modifier.padding(12.dp),
            style = TextStyle(color = Color.Gray, fontSize = 20.sp)
        )

        Divider()

    }
}

@Composable
fun CircularImage(width: Double, height: Double, radius: Double, imageUrl: String) {

    Card(modifier = Modifier
        .width(width = width.dp)
        .height(height = height.dp)
        , shape = RoundedCornerShape(radius.dp)
    ) {
        
        Image(
            painter = rememberImagePainter(data = imageUrl), 
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

    }

}
