package com.example.sky

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.Telephony
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.drawable.toDrawable
import coil.decode.withInterruptibleSource
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

//val Sents :@Composable ( c:Context, int:Int) -> Unit = { con, int ->
//    val lcon = LocalContext.current
//    Button(onClick = {
//        con.startActivity(Intent(lcon, MainActivity::class.java))
//    }) {
//        Text(text = "Sent it!")
//    }
//}


//val Sent = @Composable fun (con:Context){
////    val con = LocalContext.current
//    Button(onClick = {
//        con.startActivity(Intent(con,MainActivity::class.java))
//    }) {
//        Text(text = "Sent it!")
//    }
//}
