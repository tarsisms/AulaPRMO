package br.edu.ifal.aulaprmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold { innerPadding ->
                Surface(modifier = Modifier.padding(innerPadding)) {
                    ListViewComposable()
                }
            }
        }
    }
}

@Composable
fun ListViewComposable(modifier: Modifier = Modifier) {
    Column {
        ListItemComposable(name = "João da Silva")
        ListItemComposable(name = "Maria da Silva")
        ListItemComposable(name = "José da Silva")
        ListItemComposable(name = "João da Silva")
        ListItemComposable(name = "João da Silva")
        ListItemComposable(name = "João da Silva")
        ListItemComposable(name = "João da Silva")
        ListItemComposable(name = "João da Silva")

    }
}

@Composable
fun ListItemComposable(modifier: Modifier = Modifier, name : String) {
    Row(
        Modifier
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .fillMaxWidth(),
        //verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdQLwDqDwd2JfzifvfBTFT8I7iKFFevcedYg&s",
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Gray)
            ,
        )
        Column(
            Modifier
                .padding(start = 16.dp, top = 16.dp)
                .fillMaxWidth(0.8f)
        ) {
            Text(
                name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Mensagem",
                color = Color.Gray
            )
        }
        Column (
            Modifier.padding(top = 16.dp)
        ) {
            Text(
                "ONTEM",
                color = Color.Gray,
                fontSize = 11.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun ListViewPreview() {
    Scaffold { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            ListViewComposable()
        }
    }
}