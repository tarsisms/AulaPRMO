package br.edu.ifal.aulaprmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aulaprmo.screen.DetailScreen
import br.edu.ifal.aulaprmo.screen.HomeScreen
import br.edu.ifal.aulaprmo.ui.theme.AulaPRMOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Surface(
                Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            onNavigateToDetail = {
                                navController.navigate("detail")
                            }
                        )
                    }
                    composable("detail") { DetailScreen() }
                }
            }

            //  HomeScreen()
            // DetailScreen()
        }
    }

}