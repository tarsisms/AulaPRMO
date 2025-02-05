package br.edu.ifal.aulaprmo.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aulaprmo.database.DatabaseHelper
import br.edu.ifal.aulaprmo.domain.TourPackage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun RegisterScreen(navController: NavController) {
    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Scaffold {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = it.calculateTopPadding(), horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                textStyle = TextStyle(color = Color.Black),
                value = image,
                maxLines = 1,
                onValueChange = { value ->
                    image = value
                },
                label = { Text("Imagem") },
                // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                textStyle = TextStyle(color = Color.Black),
                value = title,
                maxLines = 1,
                onValueChange = { title = it },
                label = { Text("Titulo") },
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                textStyle = TextStyle(color = Color.Black),
                value = price,
                maxLines = 1,
                onValueChange = { price = it },
                label = { Text("Preço") },
            )

            Button(onClick = {

                var tp = TourPackage(
                    city = "",
                    previousPrice = 12300.0,
                    groupSize = 2,
                    currentPrice = price.toDouble(),
                    description = "",
                    urlImage = image,
                    title = title,
                    numNights = 10,
                )


                scope.launch {
                    withContext(Dispatchers.IO) {
                        DatabaseHelper
                            .getInstance(context)
                            .tourPackageDao()
                            .insert(tp)
                    }
                }

                navController.popBackStack()

            }) {
                Text("Submit")
            }
        }
    }
}


@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_3A,
)
@Composable
private fun PreviewRegisterScreen() {
    Surface(Modifier.padding(top = 64.dp)) {
        RegisterScreen(rememberNavController())
    }
}