package br.edu.ifal.aulaprmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Conversas", color = Color.White) },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF075E54)
                        )
                    )
                },
                modifier = Modifier.fillMaxSize(),
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(horizontal = 16.dp, vertical = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ItemMessage(
                        name = "Contatinho 2˚ Periodo",
                        message = "Oi sumida rsrs",
                        date = "SEGUNDA"
                    )
                    ItemMessage(
                        name = "Contatinho 2˚ Periodo",
                        message = "Oi sumida rsrs",
                        date = "SEGUNDA"
                    )
                    ItemMessage(
                        name = "Contatinho 2˚ Periodo",
                        message = "Oi sumida rsrs",
                        date = "SEGUNDA"
                    )
                    ItemMessage(
                        name = "Contatinho 2˚ Periodo",
                        message = "Oi sumida rsrs",
                        date = "SEGUNDA"
                    )
                    ItemMessage(
                        name = "Contatinho 2˚ Periodo",
                        message = "Oi sumida rsrs",
                        date = "SEGUNDA"
                    )

                }
            }
        }
    }
}

@Composable
fun ItemMessage(name: String, message: String, date: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        AsyncImage(
            model = "https://forbes.com.br/wp-content/uploads/2021/02/ForbesMoney-CaioCastro-150221-Divulgacao.jpg",
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)

        )
        Column {
            Text(name, fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Text(message, color = Color.Gray)
        }
        Spacer(Modifier.weight(1f))
        Text(date, fontSize = 12.sp, color = Color.Gray)
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun ItemMessagePreview() {
    ItemMessage(name = "Contatinho 2˚ Periodo", message = "Oi sumida rsrs", date = "SEGUNDA-FEIRA")
}

