package com.example.sky

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Foundation() {
    LocalIndication
    BorderStroke(20.dp, Color.Blue)
//    Canvas() // FIXME: 15/07/2021
//    Image() // FIXME: 15/07/2021
    rememberScrollState()
    DraggableState {
    }
    ScrollableState { fl: Float -> fl }
    TransformableState { zoomChange: Float, panChange: Offset, rotationChange: Float -> }
    rememberDraggableState {  }
    rememberScrollableState { fl: Float -> fl }
    rememberTransformableState {zoomChange: Float, panChange: Offset, rotationChange: Float ->  }
    MutableInteractionSource()
    Box {
    }
    BoxWithConstraints {
    }
    Column{
    }
    PaddingValues()
    Row{
    }
    Spacer(Modifier)
    LazyColumn {
    }
    LazyRow {
    }
    LazyVerticalGrid (cells = GridCells.Adaptive(1.dp)){
    }
    rememberLazyListState()
    CircleShape
    ZeroCornerSize
    AbsoluteCutCornerShape(Dp(1f))
    AbsoluteRoundedCornerShape(Dp.Hairline)
    CornerSize(1)
    CutCornerShape(1)
    RoundedCornerShape(1)
    BasicText("")
    BasicTextField("",{})
    ClickableText(AnnotatedString("")){}
    KeyboardActions {
    }
    LocalTextSelectionColors
    SelectionContainer {  }
    DisableSelection {  }
}