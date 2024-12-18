package br.edu.ifal.aulaprmo.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifal.aulaprmo.R
import coil3.compose.AsyncImage


// Pacote fixo p/ testes
val p = packages.get(0)

@Composable
fun DetailScreen() {
    Surface(Modifier.fillMaxSize()) {
        Column {
            AsyncImage(
                model = p.urlImage,
                error = painterResource(R.drawable.praia_em_cancun_mexico),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
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
                Text(
                    LoremIpsum(200).values.first(),
                    textAlign = TextAlign.Justify,
                )

            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun DetailScreenPreview() {
    DetailScreen()
}
