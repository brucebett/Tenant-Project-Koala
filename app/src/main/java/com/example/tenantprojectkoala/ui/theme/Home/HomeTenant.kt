package com.example.tenantprojectkoala.ui.theme.Home

//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountCircle
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.BottomAppBarDefaults
//import androidx.compose.material3.FloatingActionButton
//import androidx.compose.material3.FloatingActionButtonDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun HomeTenant() {
//
//    Scaffold(
//        bottomBar = {
//            BottomAppBar (
//                actions = {
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(
//                            Icons.Filled.Home,
//                            contentDescription ="Home Icon" )
//                    }
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(
//                            Icons.Filled.Settings,
//                            contentDescription = "Settings Icon")
//                    }
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(
//                            Icons.Filled.Email,
//                            contentDescription = "Email Icon")
//                    }
//                },
//                floatingActionButton = {
//                    FloatingActionButton(
//                        onClick = { /*TODO*/ },
//                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
//                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()) {
//                        Icon(
//                            Icons.Filled.AccountCircle,
//                            contentDescription ="Profile Icon" )
//                    }
//                }
//            )
//
//
//
//
//        }
//    ) {innerPadding ->
//        Column (
//            modifier = Modifier
//                .padding(innerPadding)
//                .verticalScroll(rememberScrollState())
//                .padding(10.dp)
//                .fillMaxWidth()
//        ){
//
//        }
//    }
//}

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.rememberImagePainter
import com.example.tenantprojectkoala.R


@Composable
fun HomeTenant() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.city),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(modifier = Modifier.fillMaxSize()) {
            // Search Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White.copy(alpha = 0.8f))
                    .padding(16.dp)
            ) {
                BasicTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
                    decorationBox = { innerTextField ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.bg),
                                contentDescription = null,
                                tint = Color.Gray
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            innerTextField() // TextField content
                        }
                    }
                )
            }

            // Featured Properties Carousel
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                for (i in 1..5) {
                    FeaturedPropertyCard()
                }
            }
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = { /* Handle click */ },
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .zIndex(1f),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
fun FeaturedPropertyCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(200.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f))
    ) {
        Column {
            Image(
                painter = rememberImagePainter(data = "https://example.com/property.jpg"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )
            Text(
                text = "Property Name",
                style = TextStyle(fontSize = 16.sp, color = Color.Black),
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "$1,200/month",
                style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
            )
            Button(
                onClick = { /* Handle click */ },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "View Details")
            }
        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeTenantPreview() {
    HomeTenant()
    FeaturedPropertyCard()

}