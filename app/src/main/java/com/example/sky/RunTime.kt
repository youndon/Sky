package com.example.sky

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.runtime.collection.MutableVector
import androidx.compose.runtime.collection.mutableVectorOf
import androidx.compose.runtime.internal.*
import androidx.compose.runtime.saveable.*
import androidx.compose.runtime.tooling.LocalInspectionTables
import kotlinx.coroutines.runBlocking

@SuppressLint("ProduceStateDoesNotAssignValue", "RememberReturnType")
@Suppress("UNREACHABLE_CODE")
@OptIn(InternalComposeApi::class)
@Composable
private inline fun <T, E,reified R> void() {

    currentComposer
    currentCompositeKeyHash
    currentRecomposeScope
    mutableStateOf(1)
    remember {  }
//    ComposeNode<>() // FIXME: 15/07/2021
//    Composition() // FIXME: 15/07/2021
//    CompositionLocalProvider() // FIXME: 15/07/2021
//    ControlledComposition()
    DisposableEffect(null,null) { onDispose { } }
    LaunchedEffect(null,null) {}
//    ReusableComposeNode<>()
    compositionLocalOf { }
    derivedStateOf { }
    key(""){}
    SideEffect { }
    ReusableContent({ }){ }
    mutableStateListOf<T>()
    mutableStateMapOf<E,T>()
    neverEqualPolicy<T>()
    produceState(1) { }
    referentialEqualityPolicy<T>()
    rememberCompositionContext()
    rememberCoroutineScope()
    rememberUpdatedState(1)
    simulateHotReload(1)
    snapshotFlow {  }
    sourceInformationMarkerEnd(currentComposer)
    sourceInformationMarkerStart(currentComposer,1,"")
    staticCompositionLocalOf {  }
    structuralEqualityPolicy<T>()
    runBlocking {
        withFrameMillis { frameTimeMillis: Long -> frameTimeMillis }
        withFrameNanos { frameTimeMillis: Long -> frameTimeMillis }
        withRunningRecomposer { recomposer: Recomposer -> recomposer }
    }
    MutableVector<R>()
    mutableVectorOf<R>()
    isLiveLiteralsEnabled
    composableLambda(currentComposer,1,false,{ })
    composableLambdaInstance(1,false,{ })
    composableLambdaN(currentComposer,1,false,1,{ })
    composableLambdaNInstance(1,false,1,{ })
    enableLiveLiterals()
    illegalDecoyCallException("")
    liveLiteral("",1)
    updateLiveLiteralValue("",null)
    LocalSaveableStateRegistry
    SaveableStateRegistry(mapOf()) { any: Any -> false }
    Saver<T,String>({ null }) {value: String -> null }
    SaverScope { value: Any -> false }
    autoSaver<T>()
//    listSaver<>() // FIXME: 15/07/2021
//    mapSaver() // FIXME: 15/07/2021
    rememberSaveable(null) { }
    rememberSaveableStateHolder()
    LocalInspectionTables
}