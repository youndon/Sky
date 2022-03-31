package components
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

interface Dialogs {
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun dialog() {
        Column {
            //
            AlertDialog(
                onDismissRequest = { },
                buttons = @Composable { },
                modifier = Modifier,
                title = @Composable { },
                text = @Composable { },
                shape = MaterialTheme.shapes.medium,
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = contentColorFor(backgroundColor),
                properties = DialogProperties(),
            )
        }
    }
}