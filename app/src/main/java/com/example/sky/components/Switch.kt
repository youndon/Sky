package components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

interface Switch {
    @Composable
   fun switch() {
        //
        Switch(
            checked = true,
            onCheckedChange = {},
            modifier = Modifier,
            enabled = true,
            interactionSource = remember { MutableInteractionSource() },
            colors = SwitchDefaults.colors()
        )
    }
}