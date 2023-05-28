package com.hrmoller.inputdbapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.hrmoller.inputdbapp.destinations.DbListDestination
import com.hrmoller.inputdbapp.destinations.Destination
import com.hrmoller.inputdbapp.destinations.TextFieldExampleDestination
import com.hrmoller.inputdbapp.ui.theme.InputdbappTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.dependency

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InputdbappTheme {
                val db = Room.databaseBuilder(
                    applicationContext,
                    Dbhandler::class.java, "inputDb"
                ).build()
                DestinationsNavHost(navGraph = NavGraphs.root, dependenciesContainerBuilder = { //this: DependenciesContainerBuilder<*>
                    dependency(TextFieldExampleDestination) { db }
                    dependency(DbListDestination) {db}
                })

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InputdbappTheme {
        Greeting("Android")
    }
}