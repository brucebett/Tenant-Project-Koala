package com.example.tenantprojectkoala.ui.theme.Addhouses

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import coil.compose.rememberImagePainter

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tenantprojectkoala.R
import com.example.tenantprojectkoala.ui.theme.Blue
import com.example.tenantprojectkoala.ui.theme.Green

@Composable
fun UploadHouses() {
  val imageUri = rememberSaveable() {
    mutableStateOf<Uri?>(null)
  }
//  "rememberAsyncImagePainter(ImageRequest. Builder(LocalContext. current).data(data).apply(builder).build())", 
//  imports = {"androidx. compose. ui. platform. LocalContext",
//    "coil. compose. rememberAsyncImagePainter", "coil. request. ImageRequest"}))
  val painter = rememberImagePainter(
    data = imageUri.value ?: R.drawable.image_search_24,
    builder = {crossfade(true)}
  )
    

  val launcher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.GetContent()
  ) { uri: Uri? ->
    uri?.let { imageUri.value = it }
  }

  var price by remember {
    mutableStateOf(value = "")
  }
  var size by remember {
    mutableStateOf(value = "")
  }
  var location by remember {
    mutableStateOf(value = "")
  }
  var phonenumber by remember {
    mutableStateOf(value = "")
  }
  var description by remember {
    mutableStateOf(value = "")
  }
  Box (){
    Image(painter = painterResource(id = R.drawable.background),
      contentDescription ="dashboard background",
      contentScale = ContentScale.Crop,
      modifier = Modifier.fillMaxSize())
  }
  Scaffold(){innerpadding ->
    Column(modifier = Modifier
      .padding(innerpadding)
      .verticalScroll(rememberScrollState())
      .padding(10.dp)
      .fillMaxWidth()
    ){
Text(text = "Upload House Details",
  fontSize = 30.sp,
  fontStyle = FontStyle.Normal,
  textAlign = TextAlign.Center,
  modifier = Modifier
    .fillMaxWidth()
    .padding(10.dp)
    .background(brush = Brush.horizontalGradient(colors = listOf(Green, Blue))),
  )
      Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Button(modifier = Modifier
          .background(brush = Brush.horizontalGradient(colors = listOf(Green, Blue)))
          .padding(10.dp)
          .height(60.dp)
          .width(120.dp),
          onClick = { /*TODO*/ }) {
          Text(text = "Back")
        }
        Button(modifier = Modifier
          .background(brush = Brush.horizontalGradient(colors = listOf(Green, Blue)))
          .padding(10.dp)
          .height(60.dp)
          .width(120.dp),
          onClick = { /*TODO*/ }) {
          Text(text = "Save")
        }
      }
      Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Card(shape = RectangleShape,
          modifier = Modifier
            .padding(10.dp)
            .size(180.dp)) {
          Image(painter = painter, contentDescription = null,
            modifier = Modifier
              .size(190.dp)
              .clickable { launcher.launch("image/*") },
            contentScale = ContentScale.Crop)

        }
        Text(text = "Upload Image")
      }

    }
    
    

    
  }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun UploadHousesPreview() {
  UploadHouses()
}