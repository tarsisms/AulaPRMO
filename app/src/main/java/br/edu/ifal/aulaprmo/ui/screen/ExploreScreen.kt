package br.edu.ifal.aulaprmo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aulaprmo.db.DatabaseHelper
import br.edu.ifal.aulaprmo.db.sampleDataAccommodation
import br.edu.ifal.aulaprmo.ui.components.CardAccommodation
import br.edu.ifal.aulaprmo.ui.theme.Typography
import coil.compose.AsyncImage

@Composable
fun ExploreScreen(navController: NavController) {
    // Obter Context
    val context = LocalContext.current

    // Obter lista de acomodações
    val accommodations = DatabaseHelper
        .getInstance(context)
        .accommodationDao()
        .findAll()

    // Teste p/ inserir dados no Banco
    // DatabaseHelper
    //     .getInstance(context)
    //     .accommodationDao()
    //     .insertAll(sampleDataAccommodation)

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(accommodations) { accommodation ->
                CardAccommodation(accommodation, navController = navController)
            }
        }
    }
}

