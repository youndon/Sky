package components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

interface Sliders {
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun slider() {
        Column {
            //
            Slider(
                value = 0.1f,
                onValueChange = { },
                modifier = Modifier,
                enabled = true,
                valueRange = 0f..1f,
                steps = 0,
                onValueChangeFinished = {},
                interactionSource = remember { MutableInteractionSource() },
                colors = SliderDefaults.colors()
            )
            //
            RangeSlider(
                values = 0f..0.2f,
                onValueChange = {},
                modifier = Modifier,
                enabled = true,
                valueRange = 0f..1f,
                steps = 0,
                onValueChangeFinished = {},
                colors = SliderDefaults.colors()
            )
        }
    }
}