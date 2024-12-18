package br.edu.ifal.aulaprmo.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.ifal.aulaprmo.components.CardPackage
import br.edu.ifal.aulaprmo.domain.Package


val packages = listOf(
    Package(
        urlImage = "https://cdn2.psychologytoday.com/assets/styles/manual_crop_1_1_1200x1200/public/field_blog_entry_images/2018-09/shutterstock_648907024.jpg?itok=1-9sfjwH",
        title = "Pacote Maragogi 2025",
        description = "Aereo + Hotel All Inclusive",
        currentPrice = 4500.0
    ),
    Package(
        urlImage = "https://cdn2.psychologytoday.com/assets/styles/manual_crop_1_1_1200x1200/public/field_blog_entry_images/2018-09/shutterstock_648907024.jpg?itok=1-9sfjwH",
        title = "Pacote Fortaleza 2025/2026",
        description = "Aereo + Hotel All Inclusive",
        currentPrice = 5500.0
    ),
    Package(
        urlImage = "https://cdn2.psychologytoday.com/assets/styles/manual_crop_1_1_1200x1200/public/field_blog_entry_images/2018-09/shutterstock_648907024.jpg?itok=1-9sfjwH",
        title = "Pacote Cancún 2026",
        description = "Aereo + Hotel All Inclusive",
        currentPrice = 5500.0
    ),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToDetail : () -> Unit = {}
) {
    Scaffold(topBar = {
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
                for (p in packages) {
                    Surface (
                        Modifier.clickable {
                            onNavigateToDetail()
                        }
                    ) {
                        CardPackage(p)
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
    HomeScreen()
}