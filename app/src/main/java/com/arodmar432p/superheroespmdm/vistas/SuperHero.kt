package com.arodmar432p.superheroespmdm.vistas

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arodmar432p.superheroespmdm.Superhero
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) { superhero ->
            ItemHero(superhero = superhero)
        }
    }
}

@Composable
fun ItemHero(superhero: Superhero) {
    val context = LocalContext.current
    var showToast by rememberSaveable { mutableStateOf(false) }

    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                showToast = true
            }
    ) {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "SuperHero Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()

            )
            Text(text = superhero.superheroName)
            Text(text = superhero.realName)
            Text(text = superhero.publisher, modifier = Modifier.padding(2.dp))
        }
    }

    if (showToast) {
        LaunchedEffect(Unit) {
            Toast.makeText(context, "Nombre real: ${superhero.realName}", Toast.LENGTH_SHORT).show()
            showToast = false
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