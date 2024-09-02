package com.example.tenantprojectkoala.ui.theme.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx. compose. material. OutlinedTextFieldDefaults
import coil.size.Scale
//import androidx.constraintlayout.compose.ConstraintLayout
import com.example.tenantprojectkoala.R

@Composable
fun HomeLandlord() {
    Scaffold(
        bottomBar = {
            BottomAppBar (
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.Home,
                            contentDescription ="Home Icon" )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.Settings,
                            contentDescription = "Settings Icon")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.Email,
                            contentDescription = "Email Icon")
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()) {
                        Icon(
                            Icons.Filled.AccountCircle,
                            contentDescription ="Profile Icon" )
                    }
                }
            )




        }
    ) {innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(10.dp)
                .fillMaxWidth()
        ){
//            ConstraintLayout{
//            }
            Box (modifier = Modifier
                .fillMaxWidth()
                .height(245.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.Green, Color.Blue)
                    ),
                    shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
                )


            ){
            Row(
                modifier = Modifier
                    .padding(top = 48.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth()
            ){
               Column (
                   modifier = Modifier
                       .height(100.dp)
                       .padding(start = 14.dp)
                       .weight(0.7f),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.Start
               ) {
                   Text(text = "Homepage",
                       color = Color.White,
                       fontSize = 20.sp)

                   Text(text = "Welcome to the Homepage",
                       color = Color.White,
                       fontSize = 30.sp,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(top = 14.dp, start = 5.dp)

                   )
               }
                Image(painter = painterResource(id = R.drawable.background),
                      contentDescription = null,
                      modifier = Modifier
                          .width(100.dp)
                          .height(100.dp)
                          .clickable { })
            }

            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .shadow(3.dp, shape = RoundedCornerShape(20.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ){
                Column (modifier = Modifier
                    .padding(top = 12.dp, bottom = 12.dp, end = 12.dp, start = 15.dp)
                    .height(80.dp)
                    .width(80.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(15.dp)
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(id = R.drawable.baseline_video_call_24),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 3.dp,)
                            .size(50.dp)
                    )
                    Text(text = "Video call",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Magenta
                    )
                }

                Column (modifier = Modifier
                    .padding(top = 12.dp, bottom = 12.dp, end = 12.dp, start = 15.dp)
                    .height(80.dp)
                    .width(80.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(15.dp)
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(id = R.drawable.phone_24),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 3.dp,)
                            .size(50.dp)
                    )
                    Text(text = "Phone call",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Magenta
                    )
                }

                Column (modifier = Modifier
                    .padding(top = 12.dp, bottom = 12.dp, end = 12.dp, start = 15.dp)
                    .height(80.dp)
                    .width(80.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(15.dp)
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(id = R.drawable.voice_24),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 3.dp,)
                            .size(50.dp)
                    )
                    Text(text = "Voice call",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Magenta
                    )
                }
            }


            var text by rememberSaveable { mutableStateOf("") }

            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(text = "Search for...") },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(43.dp)
                            .padding(end = 6.dp)
                    )
                },
                shape = RoundedCornerShape(50.dp),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedLabelColor = Color(android.graphics.Color.parseColor("#5e5e5e")),
//                unfocusedLabelColor = Color(android.graphics.Color.parseColor("#5e5e5e")),
//                focusedBorderColor = Color.Transparent,
//                unfocusedBorderColor = Color.Transparent
//            )
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(25.dp))
            )

            Box (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                .height(145.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.Green, Color.Blue)),
                    shape = RoundedCornerShape(20.dp)
                )
            ){

            }
        }

    }
}


@Preview (showSystemUi = true, showBackground = true)
@Composable
fun HomeLandlordPreview() {
    HomeLandlord()
}