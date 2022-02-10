package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

interface Cards {
    @ExperimentalMaterialApi
    @Composable
    fun card() {
        Card(
            onClick = {
                println("the card is clicked!")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = contentColorFor(SnackbarDefaults.backgroundColor),
            border = BorderStroke(1.dp, Color.Yellow),
            elevation = 1.dp,
            interactionSource = remember { MutableInteractionSource() },
            indication = LocalIndication.current,
            enabled = true,
            onClickLabel = "...",
            role = Role.Button,
            content = {
                Text("""
Material Design card.
Cards contain content and actions about a single subject.
!Cards image 
This version of Card will block clicks behind it.
For clickable card, please use another overload that accepts onClick as a parameter.
            """.trimIndent())
            }
        )
    }
}