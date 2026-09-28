package br.edu.ifal.aulaprmo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aulaprmo.R
import br.edu.ifal.aulaprmo.domain.Accommodation
import br.edu.ifal.aulaprmo.ui.theme.Typography
import coil.compose.AsyncImage

@Composable
fun CardAccommodation(accommodation: Accommodation, navController: NavController) {
    // Card
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.navigate("detailScreen")
            }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Box {
                AsyncImage(
                    model = accommodation.imageUrl,
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
                    accommodation.location,
                    style = Typography.headlineLarge,
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    Icons.Default.Star, contentDescription = "",
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    "${accommodation.rating}",
                    fontSize = 16.sp,
                    fontFamily = Font(R.font.manrope).toFontFamily(),
                )

            }

            Text(
                accommodation.host, color = Color(0xFF6C6C6C),
                fontFamily = Font(R.font.manrope).toFontFamily(),
            )
            Text(
                accommodation.dates,
                color = Color(0xFF6C6C6C),
                fontFamily = Font(R.font.manrope).toFontFamily(),
            )
            Text(
                "$${accommodation.total} total",
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
    CardAccommodation(
        Accommodation(
            id = 1,
            total = 2225.0,
            rating = 4.80,
            dates = "10-31 Dec",
            location = "Harlingen, Netherlands",
            host = "Professional Host",
            imageUrl = "https://news.airbnb.com/wp-content/uploads/sites/4/2019/06/PJM020719Q202_Luxe_WanakaNZ_LivingRoom_0264-LightOn_R1.jpg?fit=3200%2C2133",
        ),
        rememberNavController()
    )
}