//package com.example.sky.noteApp.ui
//
//import android.widget.CalendarView
//import androidx.appcompat.view.ContextThemeWrapper
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.compose.ui.window.Dialog
//import androidx.compose.ui.window.DialogProperties
//import kotlinx.coroutines.coroutineScope
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.runBlocking
//import kotlinx.datetime.Clock
//import kotlinx.datetime.TimeZone
//import kotlinx.datetime.toLocalDateTime
//import java.util.*
//
//
////fun date() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
//
//@Composable
//fun DatePicker(
//    minDate: Long? = null,
//    maxDate: Long? = null,
//    onDateSelected: (Date) -> Unit,
//    onDismissRequest: () -> Unit
//) {
//    val selDate = remember { mutableStateOf(Calendar.getInstance().time) }
//
//    // todo - add strings to resource after POC
//    Dialog(onDismissRequest = { onDismissRequest() }, properties = DialogProperties()) {
//        Column(
//            modifier = Modifier
//                .wrapContentSize()
//                .background(
//                    color = MaterialTheme.colorScheme.surface,
//                    shape = RoundedCornerShape(size = 16.dp)
//                )
//        ) {
//            Column(
//                Modifier
//                    .defaultMinSize(minHeight = 72.dp)
//                    .fillMaxWidth()
//                    .background(
//                        color = MaterialTheme.colorScheme.primary,
//                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
//                    )
//                    .padding(16.dp)
//            ) {
//                // TODO: Hardcoded text
//                Text(
//                    text = "Select date",
//                    style = MaterialTheme.typography.labelMedium,
//                    color = MaterialTheme.colorScheme.onPrimary
//                )
//
//                Spacer(modifier = Modifier.size(24.dp))
//
//                Text(
//                    text = DateFormat.format("MMM d, yyyy", selDate.value).toString(),
//                    style = MaterialTheme.typography.titleMedium,
//                    color = MaterialTheme.colorScheme.onPrimary
//                )
//
//                Spacer(modifier = Modifier.size(16.dp))
//            }
//
//            CustomCalendarView(
//                minDate,
//                maxDate,
//                onDateSelected = {
//                    selDate.value = it
//                }
//            )
//
//            Spacer(modifier = Modifier.size(8.dp))
//
//            Row(
//                modifier = Modifier
//                    .align(Alignment.End)
//                    .padding(bottom = 16.dp, end = 16.dp)
//            ) {
//                Button(
//                    onClick = onDismissRequest,
//                    colors = ButtonDefaults.textButtonColors(),
//                ) {
//                    //TODO - hardcode string
//                    Text(
//                        text = "Cancel",
//                    )
//                }
//
//                Button(
//                    onClick = {
//                        val newDate = selDate.value
//                        onDateSelected(
//                            // This makes sure date is not out of range
//                            Date(
//                                maxOf(
//                                    minOf(maxDate ?: Long.MAX_VALUE, newDate.time),
//                                    minDate ?: Long.MIN_VALUE
//                                )
//                            )
//                        )
//                        onDismissRequest()
//                    },
//                    colors = ButtonDefaults.textButtonColors(),
//                ) {
//                    //TODO - hardcode string
//                    Text(
//                        text = "OK",
//                    )
//                }
//
//            }
//        }
//    }
//}
//
///**
// * Used at [DatePicker] to create the calendar picker.
// * @author Arnau Mora, Joao Gavazzi
// * @param minDate The minimum date allowed to be picked.
// * @param maxDate The maximum date allowed to be picked.
// * @param onDateSelected Will get called when a date is selected.
// */
//@Composable
//private fun CustomCalendarView(
//    minDate: Long? = null,
//    maxDate: Long? = null,
//    onDateSelected: (Date) -> Unit
//) {
//    // Adds view to Compose
//    AndroidView(
//        modifier = Modifier.wrapContentSize(),
//        factory = { context ->
//            CalendarView(ContextThemeWrapper(context, 0))
//        },
//        update = { view ->
//            if (minDate != null)
//                view.minDate = minDate
//            if (maxDate != null)
//                view.maxDate = maxDate
//
//            view.setOnDateChangeListener { _, year, month, dayOfMonth ->
//                onDateSelected(
//                    Calendar
//                        .getInstance()
//                        .apply {
//                            set(year, month, dayOfMonth)
//                        }
//                        .time
//                )
//            }
//        }
//    )
//}
