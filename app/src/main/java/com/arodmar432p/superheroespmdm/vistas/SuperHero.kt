package com.arodmar432p.superheroespmdm.vistas

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arodmar432p.superheroespmdm.Superhero
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.arodmar432p.superheroespmdm.R
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed


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
@Preview(showBackground = true)
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(getSuperheroes()) { superhero ->
            ItemHero(superhero = superhero) {
                Toast.makeText(context, "Real Name: ${it.realName}", Toast.LENGTH_SHORT).show()
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ItemHero(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superhero) },
        border = BorderStroke(2.dp, Color.Red),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = superhero.superheroName,
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Real Name: ${superhero.realName}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Publisher: ${superhero.publisher}",
                modifier = Modifier.padding(2.dp))
        }
    }
}

/*
@Composable
@Preview(showBackground = true)
fun SuperHeroGridView() {
    val context = LocalContext.current
    val superheroes = getSuperheroes()
    LazyVerticalGrid<Any>(
        cells = GridCells.Adaptive(minSize = 130.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(superheroes) { superhero ->
            ItemHero(superhero = superhero) {
                Toast.makeText(context, "Real Name: ${it.realName}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
*/

@Preview(showBackground = true)
@Composable
fun PreviewItemHero() {
    val superhero = Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman)
    ItemHero(superhero = superhero, onItemSelected = {})
}


