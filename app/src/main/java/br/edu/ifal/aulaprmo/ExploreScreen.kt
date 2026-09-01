package br.edu.ifal.aulaprmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifal.aulaprmo.ui.theme.AulaPRMOTheme
import br.edu.ifal.aulaprmo.ui.theme.Typography
import coil.compose.AsyncImage

class ExploreScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AulaPRMOTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(modifier = Modifier.padding(innerPadding)) {
                        items(count = 10) {
                            Card()
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun Card() {
    Surface(modifier = Modifier.padding(16.dp)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Box {
                AsyncImage(
                    model = "https://news.airbnb.com/wp-content/uploads/sites/4/2019/06/PJM020719Q202_Luxe_WanakaNZ_LivingRoom_0264-LightOn_R1.jpg?fit=3200%2C2133",
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(bottom = 8.dp)
                        .clip(RoundedCornerShape(size = 12.dp)),
                    contentScale = ContentScale.Crop,
                )
                Icon(
                    Icons.Default.Favorite, contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopEnd)
                        .size(28.dp)
                )

            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Harlingen, Netherlands",
                    style = Typography.headlineLarge,
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    Icons.Default.Star, contentDescription = "",
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    "4.76",
                    fontSize = 16.sp,
                    fontFamily = Font(R.font.manrope).toFontFamily(),
                )

            }

            Text(
                "Professional Host", color = Color(0xFF6C6C6C),
                fontFamily = Font(R.font.manrope).toFontFamily(),
            )
            Text(
                "18 - 23 Dec",
                color = Color(0xFF6C6C6C),
                fontFamily = Font(R.font.manrope).toFontFamily(),
            )
            Text(
                "$1065 total",
                fontSize = 15.sp,
                fontWeight = FontWeight.W600,
                textDecoration = TextDecoration.Underline

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    Card()
}