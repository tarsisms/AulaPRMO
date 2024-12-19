package br.edu.ifal.aulaprmo.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aulaprmo.components.CardPackage
import br.edu.ifal.aulaprmo.database.DatabaseHelper
import br.edu.ifal.aulaprmo.database.sampleDataTourPackages


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val tourPackages = DatabaseHelper
        .getInstance(context)
        .tourPackageDao()
        .findAll()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("register")
                }
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = ""
                )
            }
        },
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF10397B), titleContentColor = Color.White
            ), title = { Text("Pesquisar") })
        }) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                for (tourPackage in tourPackages) {
                    Surface(
                        Modifier.clickable {
                            navController.navigate("detail")
                        }
                    ) {
                        CardPackage(tourPackage)
                    }
                }
            }
        }
    }
}

@Preview(
    device = Devices.PIXEL_3A
)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}