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
import br.edu.ifal.aulaprmo.api.RetrofitHelper
import br.edu.ifal.aulaprmo.domain.Address
import br.edu.ifal.aulaprmo.domain.TourPackage
import br.edu.ifal.aulaprmo.service.AddressService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response


@Composable
fun RegisterUserScreen(navController: NavController) {
    val context = LocalContext.current

    var nome by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Scaffold { innerPadding ->
        Surface(Modifier.padding(innerPadding)) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 32.dp,
                        horizontal = 16.dp,
                    ),
                verticalArrangement = Arrangement.spacedBy(16.dp)

            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Blue),
                    textStyle = TextStyle(color = Color.Black),
                    value = nome,
                    maxLines = 1,
                    onValueChange = { value ->
                        nome = value
                    },
                    label = { Text("nome") },
                    // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Blue),
                    textStyle = TextStyle(color = Color.Black),
                    value = cep,
                    maxLines = 1,
                    onValueChange = { cep = it },
                    label = { Text("cep") },
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Blue),
                    textStyle = TextStyle(color = Color.Black),
                    value = endereco,
                    maxLines = 1,
                    onValueChange = { endereco = it },
                    label = { Text("endereco") },
                )

                Button(onClick = {


                    // scope.launch {
                    //     withContext(Dispatchers.IO) {
                    //         val call: Call<Address> = RetrofitHelper().addressApi.findByCep(cep)
                    //         val response: Response<Address> = call.execute()
                    //         endereco = response.body()?.street ?: ""
                    //     }
                    // }

                    scope.launch {
                        val address = AddressService().findByCep(cep)
                        endereco = address?.street ?: "Endereço não encontrado"
                    }

                    // navController.popBackStack()

                }) {
                    Text("Submit")
                }
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
        RegisterUserScreen(rememberNavController())
    }
}