@file:Suppress("UNUSED_PARAMETER")

package com.example.sky.jetpackCompose.core

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sky.jetpackCompose.animation.Animation1Activity
import com.example.sky.jetpackCompose.animation.Animation2Activity
import com.example.sky.jetpackCompose.animation.ListAnimationActivity
import com.example.sky.jetpackCompose.animation.TextAnimationActivity
import com.example.sky.jetpackCompose.customview.CustomViewActivity
import com.example.sky.jetpackCompose.customview.CustomViewPaintActivity
import com.example.sky.jetpackCompose.customview.MeasuringScaleActivity
import com.example.sky.jetpackCompose.customview.ZoomableActivity
import com.example.sky.jetpackCompose.image.ImageActivity
import com.example.sky.jetpackCompose.layout.ConstraintLayoutActivity
import com.example.sky.jetpackCompose.layout.LayoutModifierActivity
import com.example.sky.jetpackCompose.layout.ViewLayoutConfigurationsActivity
import com.example.sky.jetpackCompose.material.AlertDialogActivity
import com.example.sky.jetpackCompose.material.BottomNavigationActivity
import com.example.sky.jetpackCompose.material.ButtonActivity
import com.example.sky.jetpackCompose.material.DrawerAppActivity
import com.example.sky.jetpackCompose.material.FixedActionButtonActivity
import com.example.sky.jetpackCompose.material.FlowRowActivity
import com.example.sky.jetpackCompose.material.MaterialActivity
import com.example.sky.jetpackCompose.material.ShadowActivity
import com.example.sky.jetpackCompose.scrollers.HorizontalScrollableActivity
import com.example.sky.jetpackCompose.scrollers.VerticalScrollableActivity
import com.example.sky.jetpackCompose.stack.StackActivity
import com.example.sky.jetpackCompose.state.ProcessDeathActivity
import com.example.sky.jetpackCompose.state.StateActivity
import com.example.sky.jetpackCompose.state.backpress.BackPressActivity
import com.example.sky.jetpackCompose.state.coroutine.CoroutineFlowActivity
import com.example.sky.jetpackCompose.state.livedata.LiveDataActivity
import com.example.sky.jetpackCompose.text.CustomTextActivity
import com.example.sky.jetpackCompose.text.SimpleTextActivity
import com.example.sky.jetpackCompose.text.TextFieldActivity
import com.example.sky.jetpackCompose.theme.DarkModeActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
        }
    }

    fun startSimpleTextExample(view: View) {
        startActivity(Intent(this, SimpleTextActivity::class.java))
    }

    fun startCustomTextExample(view: View) {
        startActivity(Intent(this, CustomTextActivity::class.java))
    }

    fun startVerticalScrollableExample(view: View) {
        startActivity(Intent(this, VerticalScrollableActivity::class.java))
    }

    fun startHorizontalScrollableExample(view: View) {
        startActivity(Intent(this, HorizontalScrollableActivity::class.java))
    }

    fun starLoadImageExample(view: View) {
        startActivity(Intent(this, ImageActivity::class.java))
    }

    // The Table API has been removed in dev11 update. Removing this example until there is a
    // better alternative available
//    fun startGridExample(view: View) {
//        startActivity(Intent(this, GridLayoutActivity::class.java))
//    }

    fun startAlertDialogExample(view: View) {
        startActivity(Intent(this, AlertDialogActivity::class.java))
    }

    fun startDrawerExample(view: View) {
        startActivity(Intent(this, DrawerAppActivity::class.java))
    }

    fun startButtonsExample(view: View) {
        startActivity(Intent(this, ButtonActivity::class.java))
    }

    fun startStateExample(view: View) {
        startActivity(Intent(this, StateActivity::class.java))
    }

    fun startCustomViewExample(view: View) {
        startActivity(Intent(this, CustomViewActivity::class.java))
    }

    fun startCustomViewPaintExample(view: View) {
        startActivity(Intent(this, CustomViewPaintActivity::class.java))
    }

    fun startAutofillTextExample(view: View) {
        startActivity(Intent(this, TextFieldActivity::class.java))
    }

    fun startStackExample(view: View) {
        startActivity(Intent(this, StackActivity::class.java))
    }

    fun startViewAlignExample(view: View) {
        startActivity(Intent(this, ViewLayoutConfigurationsActivity::class.java))
    }

    fun startMaterialDesignExample(view: View) {
        startActivity(Intent(this, MaterialActivity::class.java))
    }

    fun startFixedActionButtonExample(view: View) {
        startActivity(Intent(this, FixedActionButtonActivity::class.java))
    }

    fun startConstraintLayoutExample(view: View) {
        startActivity(Intent(this, ConstraintLayoutActivity::class.java))
    }

    fun startBottomNavigationExample(view: View) {
        startActivity(Intent(this, BottomNavigationActivity::class.java))
    }

    fun startAnimation1Example(view: View) {
        startActivity(Intent(this, Animation1Activity::class.java))
    }

    fun startAnimation2Example(view: View) {
        startActivity(Intent(this, Animation2Activity::class.java))
    }

    fun startTextInlineContentExample(view: View) {
        startActivity(Intent(this, TextAnimationActivity::class.java))
    }

    fun startListAnimation(view: View) {
        startActivity(Intent(this, ListAnimationActivity::class.java))
    }

    fun startThemeExample(view: View) {
        startActivity(Intent(this, DarkModeActivity::class.java))
    }

    fun startLayoutModifierExample(view: View) {
        startActivity(Intent(this, LayoutModifierActivity::class.java))
    }

    fun startProcessDeathExample(view: View) {
        startActivity(Intent(this, ProcessDeathActivity::class.java))
    }

    fun startLiveDataExample(view: View) {
        startActivity(Intent(this, LiveDataActivity::class.java))
    }

    fun startFlowRowExample(view: View) {
        startActivity(Intent(this, FlowRowActivity::class.java))
    }

    fun startShadowExample(view: View) {
        startActivity(Intent(this, ShadowActivity::class.java))
    }

    fun startCoroutineFlowExample(view: View) {
        startActivity(Intent(this, CoroutineFlowActivity::class.java))
    }

    fun startComposeWithClassicAndroidExample(view: View) {
//        startActivity(Intent(this, ComposeInClassicAndroidActivity::class.java))
    }

    fun startMeasuringScaleExample(view: View) {
        startActivity(Intent(this, MeasuringScaleActivity::class.java))
    }

    fun startBackPressExample(view: View) {
        startActivity(Intent(this, BackPressActivity::class.java))
    }

    fun startZoomableExample(view: View) {
        startActivity(Intent(this, ZoomableActivity::class.java))
    }
}
