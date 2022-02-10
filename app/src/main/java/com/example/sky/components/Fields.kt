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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation

interface Fields {
    @Composable fun fs() {
        val rem = remember { mutableStateOf("") }
        //
        TextField(
            value = rem.value,
            onValueChange = { rem.value = it },
            modifier = Modifier,
            enabled = true,
            readOnly = false,
            textStyle = LocalTextStyle.current,
            label = { Text("this is text field!") },
            placeholder = { Text("user input.") },
            leadingIcon = { Icon(Icons.TwoTone.Build, null) },
            trailingIcon = { Icon(Icons.Rounded.Phone, null) },
            isError = false,
            visualTransformation = VisualTransformation.None, // PasswordVisualTransformation() for password input.
            keyboardOptions = KeyboardOptions.Default,
            keyboardActions = KeyboardActions.Default,
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
        )
        @Composable { innerTextField -> innerTextField() }
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