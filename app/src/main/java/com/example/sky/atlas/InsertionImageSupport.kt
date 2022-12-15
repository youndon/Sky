package com.example.sky.atlas

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
                                add(Factory())
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
        AndroidView(factory = {
            EditText(it).apply {
                hint = "RocksDB"
                textSize = 30f
            }
        })
    }
}