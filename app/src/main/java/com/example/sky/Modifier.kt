import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

interface Modifier {
    @OptIn(ExperimentalComposeUiApi::class, androidx.compose.material.ExperimentalMaterialApi::class)
    val Modifier.ss: Any
        get() = with(this) {
//        this.all {  }
//        this.then()
//        this.zIndex()
//        this.foldIn()
//        this.foldOut()
//        this.composed {  }
//        this.absoluteOffset {  }
            this.absolutePadding()
//        this.aspectRatio()
            this.defaultMinSize()
            this.fillMaxHeight()
            this.fillMaxSize()
            this.fillMaxWidth()
            this.height(1.dp)
            this.heightIn()
//        this.offset {  }
            this.padding()
//        this.paddingFrom()
//        this.paddingFromBaseline()
//        this.requiredHeight()
            this.requiredHeightIn()
//        this.requiredSize()
            this.requiredSizeIn()
//        this.requiredWidth()
            this.requiredWidthIn()
            this.size(1.dp)
            this.sizeIn()
            this.width(1.dp)
            this.widthIn()
            this.wrapContentHeight()
            this.wrapContentSize()
            this.wrapContentWidth()
//        this.alpha()
//        this.clip()
            this.clipToBounds()
            this.drawBehind { }
//        this.drawWithCache {  }
            this.drawWithContent { }
//        this.paint()
//        this.rotate()
//        this.scale()
//        this.shadow()
            this.animateContentSize { initialValue, targetValue -> }
//        this.background()
//        this.border()
            this.clickable { }
//        this.combinedClickable {  }
            this.focusable()
//        this.horizontalScroll()
            this.clearAndSetSemantics { }
//        this.indication()
            this.progressSemantics()
            this.semantics { }
//        this.draggable()
//        this.verticalScroll()
//        this.scrollable()
//        this.transformable()
//        this.focusOrder()
//        this.focusRequester()
            this.focusTarget()
            this.onFocusChanged { }
            this.onFocusEvent { }
            this.graphicsLayer { }
            this.toolingGraphicsLayer()
//        this.layout { measurable, constraints ->  }
//        this.layoutId()
            this.onGloballyPositioned { }
            this.onSizeChanged { }
//        this.relocationRequester()
//        this.mouseScrollFilter { event, bounds ->  }
//        this.nestedScroll()
//        this.onKeyEvent {}
//        this.onPreviewKeyEvent {  }
//        this.pointerInput()
//        this.pointerMoveFilter {  }
//        this.selectable()
            this.selectableGroup()
//        this.toggleable
//        this.triStateToggleable()
//        this.swipeable()
//        this.testTag()
        }
}