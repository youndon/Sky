package com.example.sky.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState

interface CheckBox {
    @Composable fun checkBox() {
        Checkbox(
            checked = true,
            onCheckedChange = {  },
            modifier = Modifier,
            enabled = true,
            interactionSource = remember { MutableInteractionSource() },
            colors = CheckboxDefaults.colors()
        )

        TriStateCheckbox(
            state = ToggleableState.Indeterminate,
            onClick  = { },
            modifier = Modifier,
            enabled = true,
            interactionSource = remember { MutableInteractionSource() },
            colors = CheckboxDefaults.colors()
        )
    }
}

