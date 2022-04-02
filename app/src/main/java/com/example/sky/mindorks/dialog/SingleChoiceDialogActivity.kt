package com.example.sky.mindorks.dialog

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import java.util.*


// The state should be at the lower most common parent of the
// composables, which are going to interact.
val dialogState by lazy { mutableStateOf(false) }
val selectedCountry by lazy { mutableStateOf("") }

val countriesList = getCountries().values.toList()

class SingleChoiceDialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountriesDialog()
            SingleChoiceDialogActivityContent()
        }
    }
}

@Composable
fun SingleChoiceDialogActivityContent() {
    Column {
        Button(
            onClick = {
                dialogState.value = true
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue, Color.White)
        ) {
            Text(
                text = "Show Countries List",
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
        Divider(color = Color.Black)
        Text(
            text = selectedCountry.value,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}

@Composable
fun CountriesDialog() {
    SingleSelectDialog(
        dialogState = dialogState,
        title = "Choose your Country",
        optionsList = countriesList,
        submitButtonText = "Select",
        onSubmitButtonClick = { selectedCountry.value = countriesList[it] },
        onDismissRequest = { dialogState.value = false }
    )
}

// Generally it's a good habit that we create 2 composables, one which accepts
// state and one which maintain its own state. That way,
// the developer has more control ,which approach he/she wants to follow.
@Composable
fun SingleSelectDialog(
    dialogState: MutableState<Boolean>,
    title: String,
    optionsList: List<String>,
    defaultSelected: Int = -1,
    submitButtonText: String,
    onSubmitButtonClick: (Int) -> Unit,
    onDismissRequest: () -> Unit
) {
    if (dialogState.value) {
        SingleSelectDialog(
            title = title,
            optionsList = optionsList,
            defaultSelected = defaultSelected,
            submitButtonText = submitButtonText,
            onSubmitButtonClick = onSubmitButtonClick,
            onDismissRequest = onDismissRequest
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun SingleSelectDialog(
    title: String,
    optionsList: List<String>,
    defaultSelected: Int = -1,
    submitButtonText: String,
    onSubmitButtonClick: (Int) -> Unit,
    onDismissRequest: () -> Unit
) {
    val selectedOption = mutableStateOf(defaultSelected)
    Dialog(onDismissRequest = { onDismissRequest.invoke() }) {
        Surface(
            modifier = Modifier.requiredWidth(300.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = title)
                Spacer(modifier = Modifier.requiredHeight(10.dp))
                LazyColumn (
                    modifier = Modifier.requiredHeight(500.dp)
                ) {
                    items(items = optionsList) {
                        val selected = if (selectedOption.value == -1) {
                            ""
                        } else {
                            optionsList[selectedOption.value]
                        }

                        RadioButton(it, selected) { selectedValue ->
                            selectedOption.value = optionsList.indexOf(selectedValue)
                        }
                    }
                }
                Spacer(modifier = Modifier.requiredHeight(10.dp))
                Button(
                    onClick = {
                        onSubmitButtonClick.invoke(selectedOption.value)
                        onDismissRequest.invoke()
                    },
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = submitButtonText)
                }
            }

        }
    }
}


@Composable
fun RadioButton(text: String, selectedValue: String, onClickListener: (String) -> Unit) {
    Row(Modifier
        .fillMaxWidth()
        .selectable(
            selected = (text == selectedValue),
            onClick = {
                onClickListener(text)
            }
        )
        .padding(horizontal = 16.dp)
    ) {
        // The Default Radio Button in Jetpack Compose doesn't accept text as an argument.
        // So have Text Composable to show text.
        RadioButton(
            selected = (text == selectedValue),
            onClick = {
                onClickListener(text)
            }
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body1.merge(),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

// Dummy Util function for the sake of example
fun getCountries(): Map<String, String> {
    val countriesMap = hashMapOf<String, String>()
    val isoCountries = Locale.getISOCountries()
    isoCountries.forEach {
        val locale = Locale("", it)
        countriesMap[locale.country.lowercase(Locale.getDefault())] = locale.displayCountry
    }
    return countriesMap.toList().sortedBy { (_, value) -> value }.toMap()
}