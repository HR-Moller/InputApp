package com.hrmoller.inputdbapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import com.hrmoller.inputdbapp.destinations.TextFieldExampleDestination
import com.hrmoller.inputdbapp.entities.InputEntity
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

@Destination()
@Composable
fun DbList(dbhandler: Dbhandler, navigator: DestinationsNavigator){
    var entities: List<InputEntity> = runBlocking { dbhandler.inputDao().getAll() }

    Column() {
        LazyColumn(){
            items(entities){
                Column() {
                    Text(text = it.title.orEmpty())
                    Text(text = it.body.orEmpty())
                }
            }
        }
        Button(onClick = { navigator.navigate(TextFieldExampleDestination) }) {
            Text("To input page")
        }
    }

    
    


}