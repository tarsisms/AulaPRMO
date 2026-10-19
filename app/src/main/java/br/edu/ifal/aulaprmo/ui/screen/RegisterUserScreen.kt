package br.edu.ifal.aulaprmo.ui.screen


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.ifal.aulaprmo.api.RetrofitHelper
import kotlinx.coroutines.launch


@Composable
fun RegisterUserScreen() {
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
                    ), verticalArrangement = Arrangement.spacedBy(16.dp)

            ) {
                Text(
                    "Cadastro",
                    style = MaterialTheme.typography.headlineMedium,
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = nome,
                    onValueChange = { value ->
                        nome = value
                    },
                    label = { Text("Nome") },
                    shape = RoundedCornerShape(12.dp),
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = cep,
                    singleLine = true,
                    onValueChange = { cep = it },
                    label = { Text("CEP") },
                    trailingIcon = {
                        IconButton(onClick = {

                            scope.launch {
                                try {
                                    val address = RetrofitHelper().addressApi.findByCep(cep)
                                    endereco =
                                        "${address.street} - ${address.city} - ${address.state}"
                                } catch (e: Exception) {
                                    Toast.makeText(
                                        context,
                                        "Endereço não encontrado",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

                        }) {
                            Icon(Icons.Outlined.Search, contentDescription = "Buscar CEP")
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = endereco,
                    singleLine = true,
                    onValueChange = { endereco = it },
                    label = { Text("Endereço") },
                    shape = RoundedCornerShape(12.dp),
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(12.dp),
                    onClick = {
                    },
                ) {
                    Text("Cadastrar")
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
        RegisterUserScreen()
    }
}
