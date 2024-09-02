package com.example.tenantprojectkoala.ui.theme.Edithouses

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.tenantprojectkoala.R
import com.example.tenantprojectkoala.data.HouseViewModel
import com.example.tenantprojectkoala.models.House
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@Composable
fun EditHouse(navController: NavController, id: String) {
    var imageUri = rememberSaveable { mutableStateOf<Uri?>(null) }
    var existingImageUrl by rememberSaveable { mutableStateOf("") }
    val painter = rememberImagePainter(
        data = imageUri.value ?: R.drawable.image_search_24,
        builder = {crossfade(true)}
        )

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent() )
    {  uri: Uri? ->
        imageUri.value = uri
    }

    var price by remember { mutableStateOf("") }
    var size by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var phonenumber by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    val context = LocalContext.current
    val currentDataRef = FirebaseDatabase.getInstance().getReference().child("House/$id")

    DisposableEffect(Unit) {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val house = snapshot.getValue(House::class.java)
                house?.let {
                    price = it.price
                    size = it.size
                    location = it.location
                    phonenumber = it.phonenumber
                    description = it.description
                    imageUri.value = it.imageUrl?.let { uri -> Uri.parse(uri) }
                    existingImageUrl = it.imageUrl
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        }
        currentDataRef.addValueEventListener(listener)
        onDispose { currentDataRef.removeEventListener(listener) }
    }

    Column (modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(10.dp)
        .fillMaxWidth()
        .background(Color.LightGray)
    ) {
        Text(text = "EDIT HOUSE",
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.Blue)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "ALL HOUSES")
            }
            Button(onClick = { 
                val houseRepository = HouseViewModel(navController, context)
                houseRepository.editHouse(
                    context = context,
                    navController = navController,
                    filepath = imageUri.value ?: Uri.EMPTY,
                    price = price,
                    size = size,
                    location = location,
                    phonenumber = phonenumber,
                    description = description,
                    id = id,
                    currentImageUrl = existingImageUrl
                    
                )
            }) { Text(text = "EDIT")}
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(shape = CircleShape,
                modifier = Modifier
                    .padding(10.dp)
                    .size(180.dp)
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(180.dp)
                        .clickable { launcher.launch("image/*") },
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "Edit Picture Here")
        }
        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label = { Text(text = "Enter House Size")},
            placeholder = { Text(text = "Please Enter House Size")},
            value = size, 
            onValueChange = { newName -> size = newName })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun EditHousePreview() {
    EditHouse(rememberNavController(), id = "")
}