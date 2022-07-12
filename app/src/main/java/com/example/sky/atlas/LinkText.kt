package com.example.sky.atlas

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
fun LinkText() {
    val uri = LocalUriHandler.current

    val s = buildAnnotatedString {
        withStyle(SpanStyle()) {
            append("Link to ")
        }
        withStyle(SpanStyle(color = Color.Cyan)) {
            append("youtube")
        }
        addStringAnnotation("youtube", "https://www.youtube.com", 10, 17)
    }

    ClickableText(text = s, onClick = {
        s.getStringAnnotations("youtube",it,it)
            .firstOrNull()?.let { link ->
                uri.openUri(link.item)
            }
    })

}

