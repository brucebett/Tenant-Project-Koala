package com.example.tenantprojectkoala.ui.theme.Searchhouse

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.tenantprojectkoala.data.HouseViewModel
import com.example.tenantprojectkoala.models.House
import com.example.tenantprojectkoala.navigation.ROUTE_EDIT_HOUSE
import okhttp3.HttpUrl

@Composable
fun ViewHouses() {
     Column(modifier = Modifier.fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally) {

         val context = LocalContext.current
         val navController = rememberNavController()

         val productRepository = HouseViewModel(navController, context)
         val emptyUploadState = remember {
             mutableStateOf(House("", "", "", "", "", "" , ""))
         }
         val emptyUploadsListState = remember {
             mutableStateListOf<House>()
         }
         var houses = productRepository.viewHouses(emptyUploadState, emptyUploadsListState)

         Column(
             modifier = Modifier
                 .fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally
             ){
             Text(text = " All Houses",
                 fontSize = 30.sp,
                 fontFamily = FontFamily.Monospace,
                 color = Color.Black
             )

             Spacer(modifier = Modifier.height(20.dp))

             LazyColumn() {
                 items(houses) {
                     HouseItem(
                         imageUrl = it.imageUrl,
                         price = it.price,
                         size = it.size,
                         location = it.location,
                         phonenumber = it.phonenumber,
                         description = it.description,
                         id = it.id,
                         navController = navController,
                         productRepository = productRepository
                     )
                 }
             }
         }
     }
}

@Composable
fun HouseItem(imageUrl: String,price: String, size: String, location: String,
              phonenumber: String, description: String, id: String, navController: NavController, productRepository: HouseViewModel) {
    var showFullText by remember {
        mutableStateOf(false)
    }
    val context= LocalContext.current

    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .height(210.dp)
                .animateContentSize(),
            shape = MaterialTheme.shapes.medium,
            colors =CardDefaults.cardColors(
                containerColor = Color.Gray
            )
        ) {
            Row (){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(modifier = Modifier
                        .width(200.dp)
                        .height(150.dp)
                        .padding(10.dp),
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop)
                    Row {
                        Button(
                            onClick = {
                            productRepository.removeHouse(context,id,navController)
                        },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Gray)
                            ) {
                            Text(text = "REMOVE",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp)
                        }

                        Spacer(modifier = Modifier.width(5.dp))
                        Button(onClick = {
                            navController.navigate(ROUTE_EDIT_HOUSE+"/$id")
                        },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Gray)
                            ) {
                            Text(text = "EDIT",
                                 color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )

                        }

                    }

                }

                Column (modifier = Modifier
                    .padding(vertical = 20.dp, horizontal = 15.dp)
                    .verticalScroll(
                        rememberScrollState()
                    )){
                    Text(text = "PRICE",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = price,
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "SIZE",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = size,
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "LOCATION",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = location,
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "PHONENUMBER",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = phonenumber,
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "DESCRIPTION",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold)
                    Text(modifier = Modifier.clickable {
                        showFullText = !showFullText
                    },
                        text = description,
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = if (showFullText) 100 else 2,
                        overflow = TextOverflow.Ellipsis)


                }
            }

        }
    }

}


//@Preview (showSystemUi = true, showBackground = true)
//@Composable
//fun ViewHousesPreview() {
//    ViewHouses()
//}