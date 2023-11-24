package com.arodmar432p.superheroespmdm

import androidx.annotation.DrawableRes

data class Superhero(
    val superheroName: String,
    val realName: String,
    val publisher: String,
    @DrawableRes var photo: Int
)
