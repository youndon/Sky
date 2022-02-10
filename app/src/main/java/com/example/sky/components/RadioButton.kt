package components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

interface RadioButton {
    @Composable
    fun radio() {
        RadioButton(
            selected = false,
            onClick = {},
            modifier = Modifier,
            enabled = true,
            interactionSource = remember { MutableInteractionSource() },
            colors = RadioButtonDefaults.colors()
        )
    }
}