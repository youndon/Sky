package com.example.sky.mindorks.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sky.R

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.scrollable(rememberScrollState(),Orientation.Vertical)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = "This is a Simple Image"
                )
                SimpleImageComponent()
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = "This is an image with rounded corners"
                )
                RoundedImageComponent()
            }
        }
    }
}

@Composable
fun SimpleImageComponent() {
    // Image is a composable that is used to display some image.
    val image = painterResource(R.drawable.ic_launcher_background)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(image,null)
    }
}

@Composable
fun RoundedImageComponent() {
    val image = painterResource(R.drawable.mindorks_cover)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // contentScale is used to find the scaling aspect ratio
        Image(
            painter = image,
            null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit
        )
    }
}