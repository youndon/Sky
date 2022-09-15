package com.example.sky.firebase.firestore

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

val user01 = 1 to "landrover" to "..."
val user02 = 2 to "Mercedes" to "GClass"

@Composable
fun Fs() {
    val ctx = LocalContext.current
    val userDocument = "landRoverUser"
    val db = Firebase.firestore


    val coll = "all_users"

    db.collection(coll).document()

    db.collection(coll)
        .document(userDocument)
        .update("first",2)

    db.collection(coll)
        .get()
        .addOnSuccessListener { snapshot ->
            snapshot.forEach {
                println(it)
            }
        }
}