package com.hrmoller.inputdbapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hrmoller.inputdbapp.destinations.DbListDestination
import com.hrmoller.inputdbapp.entities.InputEntity
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.runBlocking

@Destination(start = true)
@Composable
fun TextFieldExample(
    navigator: DestinationsNavigator,
    dbhandler: Dbhandler
) {
    // Create a mutable state for the text value
    val textState = remember { mutableStateOf("") }

    // Create a column layout
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the text value
        Text(
            text = "Text entered: ${textState.value}",
            style = MaterialTheme.typography.headlineMedium
        )

        // Create a TextField
        TextField(
            value = textState.value,
            onValueChange = { newValue ->
                // Update the text value when it changes
                textState.value = newValue
            },
            label = { Text("Enter text") }
        )

        // Create a button to clear the text
        Button(
            onClick = {
                runBlocking { dbhandler.inputDao().insertAll(InputEntity(0,textState.value,"")) }
                textState.value = ""
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Clear Text")
        }

        Button(onClick = { navigator.navigate(DbListDestination()) }) {
            Text("To list page")
        }
    }
}