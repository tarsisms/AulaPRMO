package br.edu.ifal.aulaprmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aulaprmo.ui.theme.AulaPRMOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            // Opção 01
            // AirbnbApp(content = { })

            // Opção 02
            AirbnbApp { // Implementação do Content
                NavHost(
                    navController = navController,
                    startDestination = "exploreScreen"
                ) {

                    composable("exploreScreen") {
                        ExploreScreen(navController = navController)
                    }

                    composable("detailScreen") {
                        DetailScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun AirbnbApp(
    content: @Composable () -> Unit //void
) {
    AulaPRMOTheme {
        Scaffold { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = innerPadding.calculateTopPadding())
            ) {
                content()
            }
        }
    }
}