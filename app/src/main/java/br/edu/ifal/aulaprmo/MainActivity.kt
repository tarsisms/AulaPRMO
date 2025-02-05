package br.edu.ifal.aulaprmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aulaprmo.screen.DetailScreen
import br.edu.ifal.aulaprmo.screen.HomeScreen
import br.edu.ifal.aulaprmo.screen.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            Scaffold { innerPadding ->
                Surface(
                    Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App() {
                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") {
                                HomeScreen(navController = navController)
                            }
                            composable("detail") {
                                DetailScreen()
                            }
                            composable("register") {
                                RegisterScreen(navController = navController)
                            }
                        }
                    }
                }
            }

        }
    }

    @Composable
    fun App(content: @Composable () -> Unit) {
        Scaffold {
            Surface(Modifier.padding(top = it.calculateTopPadding())) {
                content()
            }
        }
    }

}