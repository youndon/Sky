package com.example.sky.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

interface CRB {
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun some() {
        //
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Top,
            // Top, Center, Bottom, Start, SpaceBetween, SpaceAround, SpaceEvenly, End
            horizontalAlignment = Alignment.Start,
            // Start,End, Center, CenterStart, CenterEnd, CenterVertically,CenterHorizontally
            // Top,TopStart, TopEnd,TopCenter, Bottom, BottomStart, BottomEnd,
            // BottomCenter
        ) {

        }
        //
        LazyColumn(
            modifier = Modifier,
            state = rememberLazyListState(),
            contentPadding = PaddingValues(0.dp),
            reverseLayout = false,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            flingBehavior = ScrollableDefaults.flingBehavior(),
            content = {/*unit*/})
        //
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
        ) {

        }
        //
        LazyRow(
            modifier = Modifier,
            state = rememberLazyListState(),
            contentPadding = PaddingValues(0.dp),
            reverseLayout = false,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
            flingBehavior = ScrollableDefaults.flingBehavior(),
            content = {/*unit*/}
        )
        //
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center,
            propagateMinConstraints = false
        ) {
        }

        //
        BoxWithConstraints(
            modifier = Modifier,
            contentAlignment = Alignment.TopStart,
            propagateMinConstraints = false,
        ) {
        }
    }
}