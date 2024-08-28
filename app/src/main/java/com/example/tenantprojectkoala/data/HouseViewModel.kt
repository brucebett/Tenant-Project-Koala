package com.example.tenantprojectkoala.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.tenantprojectkoala.models.House
import com.example.tenantprojectkoala.navigation.ROUTE_TENANT_LOGIN
import com.example.tenantprojectkoala.navigation.ROUTE_VIEW_HOUSES
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID


class HouseViewModel (var navController: NavController,var context: Context) {
    var  authRepository: AuthViewModel

    init {
        authRepository= AuthViewModel(navController, context)
       if (!authRepository.isloggedin()){
        navController.navigate(ROUTE_TENANT_LOGIN)
       }
}

    fun saveHouse(
        filepath: Uri, price: String, size: String, location: String, phonenumber: String, description: String,
    ){
        var id = System.currentTimeMillis().toString()
        var storageReference = FirebaseStorage.getInstance().getReference().child("Passport/$id")

        storageReference.putFile(filepath).addOnCompleteListener {
         if (it.isSuccessful){
             storageReference.downloadUrl.addOnSuccessListener {
                 var imageUrl = it.toString()
                 var houseData = House(imageUrl,price,size, location, phonenumber, description, id)
                 var dbRef = FirebaseDatabase.getInstance().getReference().child("House/$id")
                 dbRef.setValue(houseData)
                 Toast.makeText(context, "House Uploaded Successfully", Toast.LENGTH_LONG).show()

             }
         }else{
             Toast.makeText(context, "${it.exception!!.message}",Toast.LENGTH_LONG).show()

         }
        }

    }

    fun viewHouses(house: MutableState<House>, houses: SnapshotStateList<House>): SnapshotStateList<House>{
        var ref = FirebaseDatabase.getInstance().getReference().child("House")


        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                houses.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(House::class.java)
                    house.value = value!!
                    houses.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()

            }
            })
        return houses
    }

    fun editHouse(
        context: Context,
        navController: NavController,
        filepath: Uri,
        price: String,
        size: String,
        location: String,
        phonenumber: String,
        description: String,
        id: String,
        currentImageUrl: String
    ){
        val databaseReference = FirebaseDatabase.getInstance().getReference("House/$id")

        if (filepath != Uri.EMPTY){
        val storageReference = FirebaseStorage.getInstance().reference
        val imageRef = storageReference.child("passport/${UUID.randomUUID()}.jpg")

        imageRef.putFile(filepath)
            .addOnSuccessListener {
                imageRef.downloadUrl.addOnSuccessListener { uri ->
                    val imageUrl = uri.toString()
                    val editHouse =
                        House(imageUrl, price, size, location, phonenumber, description, id)

                    databaseReference.setValue(editHouse)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(context, "Edit Successful", Toast.LENGTH_SHORT).show()
                                navController.navigate(ROUTE_VIEW_HOUSES)
                            } else {
                                Toast.makeText(context, "Edit failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()

                            }
                        }
                  }
                }
                 .addOnFailureListener { exception ->
                      Toast.makeText(context, "Image Upload Failed: ${exception.message}", Toast.LENGTH_SHORT).show()

            }
            }else{
                val editedHouse = House(currentImageUrl, price, size, location, phonenumber, description, id)
                  databaseReference.setValue(editedHouse)
                      .addOnCompleteListener { task ->
                          if (task.isSuccessful){
                              Toast.makeText(context, "Edit successful", Toast.LENGTH_SHORT).show()
                              navController.navigate(ROUTE_VIEW_HOUSES)
                          }else{
                              Toast.makeText(context, "Edit Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()

                          }
                      }
            }
    }


    fun removeHouse(context: Context, id: String, navController: NavController) {

        val progressDialog = ProgressDialog(context).apply {
            setMessage("Removing House.....Please wait")
            setCancelable(false)
            show()
        }

        val delRef = FirebaseDatabase.getInstance().getReference("House/$id")
        delRef.removeValue().addOnCompleteListener { task ->
            progressDialog.dismiss()
            if (task.isSuccessful) {
                Toast.makeText(context, "House Removed Successfully", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_VIEW_HOUSES)
            }else{
                Toast.makeText(context, task.exception?.message ?: "Process Failed", Toast.LENGTH_SHORT).show()

            }
        }
    }

}