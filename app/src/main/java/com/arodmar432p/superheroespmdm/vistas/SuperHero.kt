package com.arodmar432p.superheroespmdm.vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arodmar432p.superheroespmdm.Superhero
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arodmar432p.superheroespmdm.R


fun getSuperheroes() = listOf(
    Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
    Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
    Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
    Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
    Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash),
    Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
    Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
)

@Composable
fun SuperHeroView() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) { superhero ->
            ItemHero(superhero = superhero)
        }
    }
}

@Composable
fun ItemHero(superhero: Superhero) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { /* Handle click */ }
    ) {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "SuperHero Avatar",
                contentScale = ContentScale.Crop
            )
            Text(text = superhero.superheroName)
            Text(text = superhero.realName)
            Text(text = superhero.publisher)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSuperHeroView() {
    SuperHeroView()
}

@Preview(showBackground = true)
@Composable
fun PreviewItemHero() {
    val superhero = Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman)
    ItemHero(superhero = superhero)
}
