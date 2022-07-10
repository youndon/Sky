package com.example.sky

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SwipeableState
import androidx.compose.material.swipeable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.*
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.*
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlin.coroutines.RestrictsSuspension

interface Modifier {
    @OptIn(ExperimentalComposeUiApi::class,
        androidx.compose.material.ExperimentalMaterialApi::class,
        androidx.compose.foundation.ExperimentalFoundationApi::class)
    val Modifier.ss: Any
        @SuppressLint("UnnecessaryComposedModifier")
        get() = with(this) {
            this.all { element: Modifier.Element -> true }
            this.then(this)
            this.zIndex(1f)
            this.foldIn(0) { i: Int, element: Modifier.Element -> i }
            this.foldOut(0) { element: Modifier.Element, i: Int -> i }
            this.composed("", null, { InspectorInfo() }) { this }
            this.absoluteOffset()
            this.absolutePadding()
            this.aspectRatio(1f)
            this.defaultMinSize()
            this.fillMaxHeight()
            this.fillMaxSize()
            this.fillMaxWidth()
            this.height(1.dp)
            this.heightIn()
            this.offset()
            this.padding()
//        this.paddingFrom()
//        this.paddingFromBaseline()
            this.requiredHeight(IntrinsicSize.Max /*Min.*/)
            this.requiredHeightIn()
            this.requiredSize(1.dp, 1.dp)
            this.requiredSizeIn()
            this.requiredWidth(IntrinsicSize.Max)
            this.requiredWidthIn()
            this.size(1.dp)
            this.sizeIn()
            this.width(1.dp)
            this.widthIn()
            this.wrapContentHeight()
            this.wrapContentSize()
            this.wrapContentWidth()
            this.alpha(1f) // Transparency of the component.
            this.clip(CircleShape)
            this.clipToBounds()
            this.drawBehind {
            }
//        this.drawWithCache {  }
            this.drawWithContent {
            }
//        this.paint()
            this.rotate(1f)
            this.scale(1f)
            this.shadow(1.dp)
            this.animateContentSize { initialValue, targetValue -> }
            this.background(Color.Gray)
            this.border(BorderStroke(1.dp, Color.Gray))
            this.clickable {
            }
            this.combinedClickable {
            }
            this.focusable()
            this.horizontalScroll(ScrollState(0))
            this.clearAndSetSemantics {
            }
//        this.indication()
            this.progressSemantics()
            this.semantics {
            }
            this.draggable(state = DraggableState { }, orientation = Orientation.Vertical)
            this.verticalScroll(ScrollState(0))
            this.scrollable(ScrollableState { 1f }, Orientation.Vertical)
            this.transformable(TransformableState { zoomChange, panChange, rotationChange -> })
            this.focusRequester(FocusRequester.Default)
            this.focusTarget()
            this.onFocusChanged {
            }
            this.onFocusEvent {
            }
            this.graphicsLayer {
            }
            this.toolingGraphicsLayer()
//        this.layout { measurable, constraints ->  }
            this.layoutId("")
            this.onGloballyPositioned {
            }
            this.onSizeChanged {
            }
//        this.nestedScroll()
            this.onKeyEvent {
                true
            }
            this.onPreviewKeyEvent {
                true
            }
            this.pointerInput(null) {
            }
            this.selectable(true) {
            }
            this.selectableGroup()
            this.toggleable(true) {}
            this.triStateToggleable(ToggleableState.On) {}
            this.swipeable(SwipeableState(0), mapOf(), Orientation.Horizontal)
            this.testTag("")
        }
}