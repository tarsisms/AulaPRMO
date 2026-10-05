package br.edu.ifal.aulaprmo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import br.edu.ifal.aulaprmo.db.DatabaseHelper
import br.edu.ifal.aulaprmo.domain.Accommodation
import br.edu.ifal.aulaprmo.ui.components.CardAccommodation

@Composable
fun ExploreScreen(navController: NavController) {
    // Obter Context
    val context = LocalContext.current
    var accommodationsList = remember { mutableStateListOf<Accommodation>() }

    /** Codigo p/ inserir dados no Banco */
    // DatabaseHelper
    //     .getInstance(context)
    //     .accommodationDao()
    //     .insertAll(sampleDataAccommodation)


    /** Coroutine c/ CoroutineScope.launch */
    // Obter lista de acomodações
    // val scope = CoroutineScope(Dispatchers.IO)
    // val scope = rememberCoroutineScope()
    // scope.launch {
    //     val accommodations = DatabaseHelper
    //         .getInstance(context)
    //         .accommodationDao()
    //         .findAll()
    //     accommodationsList.addAll(accommodations)
    //     Toast.makeText(context, "Carregou hospedagens", Toast.LENGTH_SHORT).show()
    // }

    /** Coroutine c/ LaunchedEffect e withContext(Dispatchers.IO) */
    // LaunchedEffect(Unit) {
    //     withContext(Dispatchers.IO) {
    //         val accommodations = DatabaseHelper
    //             .getInstance(context)
    //             .accommodationDao()
    //             .findAll()
    //         accommodationsList.addAll(accommodations)
    //     }
    // }

    /** Coroutine c/ LaunchedEffect e Suspended Function */
    LaunchedEffect(Unit) {
        val accommodations = DatabaseHelper
            .getInstance(context)
            .accommodationDao()
            .findAllSuspendFunction()

        accommodationsList.addAll(accommodations)
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(accommodationsList) { accommodation ->
                CardAccommodation(accommodation, navController = navController)
            }
        }
    }
}

