package com.example.sky

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.*
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Popup
import org.xml.sax.InputSource

@SuppressLint("ResourceType")
@OptIn(ExperimentalComposeUiApi::class, ExperimentalUnitApi::class)
@Composable
private fun Ui() {
    CornerRadius(1f,1f)
    Offset(1f,1f)
    Rect(1f,1f,1f,1f)
    RoundRect(1f,1f,1f,1f,1f,1f)
    Size(1f,1f)
    lerp(Dp.Hairline, Dp.Hairline,1f)
    DefaultAlpha
    DefaultCameraDistance
    RectangleShape
    Canvas(ImageBitmap(1,1))
    Color(1)
    GraphicsLayerScope()
    ImageBitmap(1,1)
    ImageShader(ImageBitmap(1,1))
    LinearGradientShader(Offset.Zero, Offset.Zero, listOf())
    Paint()
    PathMeasure()
    RadialGradientShader(Offset.Zero,1f, listOf())
    ShaderBrush(Shader())
    SweepGradientShader(Offset.Zero, listOf())
    TransformOrigin(1f,1f)
//    NativeCanvas // typealias of org.jetbrains.skija.Canvas
//    NativePaint // typealias if org.jetbrains.skija.Paint
//    Shader // typealias of org.jetbrains.skija.Shader
    DefaultFillType
    DefaultGroupName
    DefaultPathName
    DefaultPivotX
    DefaultPivotY
    DefaultRotation
    DefaultScaleX
    DefaultScaleY
    DefaultStrokeLineCap
    DefaultStrokeLineJoin
    DefaultStrokeLineMiter
    DefaultStrokeLineWidth
    DefaultTintBlendMode
    DefaultTintColor
    DefaultTranslationX
    DefaultTranslationY
    DefaultTrimPathEnd
    DefaultTrimPathOffset
    DefaultTrimPathStart
    EmptyPath
    RootGroupName
    Group {  }
    Path()
    PathData {  }
    addPathNodes("")
    rememberVectorPainter(Dp.Hairline, Dp.Hairline){viewportWidth: Float, viewportHeight: Float ->  }
    Key(1)
//    NativeKeyEvent // typealias of java.awt.event.KeyEvent
    FirstBaseline
    LastBaseline
//    Layout() // FIXME: 16/07/2021
//    MeasurePolicy() // FIXME: 16/07/2021
    ScaleFactor(1f,1f)
//    SubcomposeLayout { } // FIXME: 16/07/2021
    LocalAccessibilityManager
    LocalAutofill
    LocalAutofillTree
    LocalClipboardManager
    LocalDensity
    LocalFocusManager
    LocalHapticFeedback
    LocalInspectionMode
    LocalLayoutDirection
    LocalTextInputService
    LocalTextToolbar
    LocalUriHandler
    LocalViewConfiguration
    LocalWindowInfo
    NoInspectorInfo
    isDebugInspectorInfoEnabled
    debugInspectorInfo {  }
    painterResource(1)
    InputSource()
    painterResource(1)
    painterResource(1)
    ToggleableState(false)
    AnnotatedString("")
//    Paragraph() // FIXME: 16/07/2021
    object :Font.ResourceLoader{
        override fun load(font: Font): Any {
            TODO("Not yet implemented")
        }
    }
    ParagraphIntrinsics(
        text = "",
        style = TextStyle.Default,
        spanStyles = listOf(),
        placeholders = listOf(),
        density = Density(LocalContext.current),
        fontFamilyResolver = LocalFontFamilyResolver.current
    )
    TextRange(1)
    buildAnnotatedString {  }
    resolveDefaults(TextStyle.Default,LayoutDirection.Ltr)
    FontFamily()
    Font(1)
    Constraints()
    Density(1f,1f)
    DpOffset(Dp.Hairline, Dp.Hairline)
    IntOffset(1,1)
    IntRect(IntOffset.Zero, IntOffset.Zero)
    IntSize(1,1)
    TextUnit(1f, TextUnitType.Sp)
    Velocity(1f,1f)
    max(Dp(1f),Dp(1f))
    min(Dp(1f),Dp(1f))
//    Dialog() // FIXME: 16/07/2021
    Popup {  }
    DpSize(Dp.Hairline, Dp.Hairline)
}