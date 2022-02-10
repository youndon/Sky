package components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.*
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*

interface Texts {
    @Composable fun ts(s:String ) {
        Column {
            //
            ClickableText(
                text = buildAnnotatedString { },
                modifier = Modifier,
                style = TextStyle.Default,
                softWrap = true,
                overflow = TextOverflow.Clip,
                maxLines = Int.MAX_VALUE,
                onTextLayout = {}
            ) {
            }
            //
            Text(
                text = "",
                modifier = Modifier,
                color = Color.Unspecified,
                fontSize = TextUnit.Unspecified,
                fontStyle = null,
                fontWeight = null,
                fontFamily = null,
                letterSpacing = TextUnit.Unspecified,
                textDecoration = null,
                textAlign = null,
                lineHeight = TextUnit.Unspecified,
                overflow = TextOverflow.Clip,
                softWrap = true,
                maxLines = Int.MAX_VALUE,
                onTextLayout = {},
                style = LocalTextStyle.current
            )
            //
            BasicText(
                text = buildAnnotatedString { },
                modifier = Modifier,
                style = TextStyle.Default,
                onTextLayout = {},
                overflow = TextOverflow.Clip,
                softWrap = true,
                maxLines = Int.MAX_VALUE,
                inlineContent = mapOf(),
            )
        }
    }
    fun myStyle() = TextStyle(
        color = Color.Black,
        fontSize = 25.sp,
        fontWeight = FontWeight.W500,
        fontStyle = FontStyle.Normal,
        fontSynthesis = FontSynthesis.All,
        fontFamily = FontFamily.SansSerif,
        fontFeatureSettings = "css format",
        letterSpacing = 1.sp,
        baselineShift = BaselineShift.Subscript,
        textGeometricTransform = TextGeometricTransform(),
        localeList = LocaleList.current,
        background = Color.Gray,
        textDecoration = TextDecoration.None,
        shadow = Shadow(Color.Blue),
        textAlign = TextAlign.Justify,
        textDirection = TextDirection.Ltr,
        lineHeight = 30.sp,
        textIndent = TextIndent()
    )
}