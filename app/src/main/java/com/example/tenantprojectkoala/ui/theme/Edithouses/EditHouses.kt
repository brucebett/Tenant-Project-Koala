package com.example.tenantprojectkoala.ui.theme.Edithouses

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.tenantprojectkoala.R
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
}
