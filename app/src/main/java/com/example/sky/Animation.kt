package com.example.sky

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import kotlinx.coroutines.runBlocking

@SuppressLint("UnrememberedAnimatable")
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun <T> Animation() {
    Animatable(Color.Blue)
    AnimatedVisibility(false){}
//    Crossfade() // FIXME: 14/07/2021
    animateColorAsState(Color.Magenta)
    expandIn()
    expandHorizontally()
    expandVertically()
    fadeIn()
    fadeOut()
    rememberSplineBasedDecay<T>()
    shrinkOut()
    shrinkHorizontally()
    shrinkVertically()
    slideIn(){ IntOffset.Zero}
    slideOut(){ IntOffset.Zero }
    slideInHorizontally()
    slideInVertically()
    slideOutHorizontally()
    slideOutVertically()
    splineBasedDecay<T>(Density(1f))

    // animation.core
    FastOutLinearInEasing
    FastOutSlowInEasing
    LinearEasing
    LinearOutSlowInEasing
    Animatable(Color.LightGray)
    AnimationState(1f)
    AnimationVector(1f,1f,1f,1f)
//    DecayAnimation() // FIXME: 14/07/2021
    Easing { fraction: Float -> fraction }
//    TargetBasedAnimation() // FIXME: 14/07/2021
//    TwoWayConverter() // FIXME: 14/07/2021
    suspend {
        animate(1f,1f){value, velocity ->  }
        withInfiniteAnimationFrameMillis { frameTimeMillis: Long ->  }
        withInfiniteAnimationFrameNanos { frameTimeMillis: Long ->  }
    }
//    animateDecay() // FIXME: 14/07/2021
    animateDpAsState(Dp.Hairline)
    animateFloatAsState(1f)
    animateIntAsState(1)
    animateIntOffsetAsState(IntOffset.Zero)
    animateIntSizeAsState(IntSize.Zero)
    animateOffsetAsState(Offset.Zero)
//    animateValueAsState() // FIXME: 14/07/2021
    animateSizeAsState(Size.Zero)
    animateRectAsState(Rect.Zero)
    estimateAnimationDurationMillis(1.0,1.0,1.0,1.0,1.0)
    exponentialDecay<T>()
//    infiniteRepeatable() // FIXME: 14/07/2021
    keyframes<T> {  }
    rememberInfiniteTransition()
//    repeatable() // FIXME: 14/07/2021
    snap<T>()
    spring<T>()
    tween<T>()
//    updateTransition() // FIXME: 14/07/2021
}