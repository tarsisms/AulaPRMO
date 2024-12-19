package br.edu.ifal.aulaprmo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifal.aulaprmo.R
import br.edu.ifal.aulaprmo.database.sampleDataTourPackages
import br.edu.ifal.aulaprmo.domain.TourPackage
import br.edu.ifal.aulaprmo.extensions.toBrazilianCurrency

import coil3.compose.AsyncImage


@Composable
fun CardPackage(p: TourPackage) {
    Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            AsyncImage(
                model = p.urlImage,
                error = painterResource(R.drawable.praia_em_cancun_mexico),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    p.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                )
                Text(p.description)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Outlined.Settings, contentDescription = "")
                    Text("${p.numNights} Diárias")
                    Icon(Icons.Outlined.Person, contentDescription = "")
                    Text("${p.groupSize} Pessoa")
                }
                Text("A partir de ${p.previousPrice.toBrazilianCurrency()}")
                Text(
                    p.currentPrice.toBrazilianCurrency(),
                    color = Color(0xFFFD6C00),
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                )
                Text(
                    "Cancelamento Grátis!",
                    color = Color(0xFF3FDA3C)
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun CardPackagePreview() {
    Surface(
        Modifier.padding(16.dp)
    ) {
        CardPackage(sampleDataTourPackages[0])
    }
}
