package com.example.sky.atlas

import android.graphics.Color.CYAN
import android.net.Uri
import android.os.Build.VERSION.SDK_INT
import android.view.OnReceiveContentListener
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.inputmethod.EditorInfoCompat
import androidx.core.view.inputmethod.InputConnectionCompat
import coil.ComponentRegistry
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder

@Preview
@Composable
fun InsertionImageSupport() {

    var gifUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current

    var c by remember { mutableStateOf("") }

    Column {
        Image(
            rememberAsyncImagePainter(gifUri,
                imageLoader = remember {
                    ImageLoader(context).newBuilder()
                        .components(fun ComponentRegistry.Builder.() {
                            if (SDK_INT >= 28) {
                                add(ImageDecoderDecoder.Factory())
                            } else {
                                add(GifDecoder.Factory())
                            }
                        }).build()
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { context ->
            val editText = @Suppress("all") object : EditText(context) {

                override fun setOnReceiveContentListener(
                    mimeTypes: Array<out String>?,
                    listener: OnReceiveContentListener?
                ) {
                    super.setOnReceiveContentListener(mimeTypes, listener)
                }

                override fun onCreateInputConnection(editorInfo: EditorInfo): InputConnection {
                    val ic = super.onCreateInputConnection(editorInfo)
                    EditorInfoCompat.setContentMimeTypes(editorInfo, arrayOf("*/*"))

                    val callback =
                        InputConnectionCompat.OnCommitContentListener { inputContentInfo, _, _ ->
                            runCatching {
                                inputContentInfo.requestPermission()
                            }.onFailure { return@OnCommitContentListener false }
                            gifUri = inputContentInfo.contentUri
                            true
                        }
                    return InputConnectionCompat.createWrapper(ic, editorInfo, callback)
                }
            }
            editText.apply {
                this.textSize = 30f
                hint = "land rover"
                isSingleLine = true
                setTextColor(CYAN)
                setBackgroundResource(android.R.color.transparent)

            }
        }) {}

    }
}