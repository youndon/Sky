package components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.twotone.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

interface Fields {
    @Composable fun fs() {
        val rem = remember { mutableStateOf("") }
        val manager = LocalFocusManager.current
        //
        TextField(
            value = rem.value,
            onValueChange = { rem.value = it },
            modifier = Modifier,
            enabled = true,
            readOnly = false,
            textStyle = LocalTextStyle.current,
            label = @Composable { Text("label") },
            placeholder = @Composable { Text("place holder") },
            leadingIcon = @Composable { Icon(Icons.TwoTone.Build, null) },
            trailingIcon = @Composable { Icon(Icons.Rounded.Phone, null) },
            isError = false,
            visualTransformation = VisualTransformation.None, // PasswordVisualTransformation() for password input.
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None, // Characters, Words, Sentences.
                autoCorrect = true,
                keyboardType = KeyboardType.Text, // Ascii, Number, Phone, Uri, Email, Password, NumberPassword.
                imeAction = ImeAction.Default // Go, Search, Send, Previous, Next, Done.
            ),
            keyboardActions = KeyboardActions(
                // onGo, onNext, onPrevious, onSearch, onSend.
                onDone = {
                    manager.moveFocus(FocusDirection.Next) // Previous, Up, Down, Left, Right, In, Out
                    manager.clearFocus(false)
                },
            ),
            singleLine = false,
            maxLines = 200,
            interactionSource = remember { MutableInteractionSource() },
            shape = MaterialTheme.shapes.small.copy(bottomEnd = ZeroCornerSize, bottomStart = ZeroCornerSize),
            colors = TextFieldDefaults.textFieldColors()
        )
        //
        BasicTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier,
            enabled = true,
            readOnly = false,
            textStyle = TextStyle.Default,
            keyboardOptions = KeyboardOptions.Default,
            keyboardActions = KeyboardActions.Default,
            singleLine = false,
            maxLines = Int.MAX_VALUE,
            visualTransformation = VisualTransformation.None,
            onTextLayout = {},
            interactionSource = remember { MutableInteractionSource() },
            cursorBrush = SolidColor(Color.Black)
        ) { innerTextField -> innerTextField() }
        //
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier,
            enabled = true,
            readOnly = false,
            textStyle = LocalTextStyle.current,
            label = @Composable {},
            placeholder = @Composable {},
            leadingIcon = @Composable {},
            trailingIcon = @Composable {},
            isError = false,
            visualTransformation = VisualTransformation.None,
            keyboardOptions = KeyboardOptions.Default,
            keyboardActions = KeyboardActions.Default,
            singleLine = false,
            maxLines = Int.MAX_VALUE,
            interactionSource = remember { MutableInteractionSource() },
            shape = MaterialTheme.shapes.small,
            colors = TextFieldDefaults.outlinedTextFieldColors()
        )
    }
}