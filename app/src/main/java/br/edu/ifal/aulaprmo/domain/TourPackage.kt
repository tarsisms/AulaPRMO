package br.edu.ifal.aulaprmo.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TourPackage(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    val urlImage: String,
    val title: String,
    val city: String,
    val numNights : Int,
    val groupSize : Int,
    val description: String,
    val currentPrice: Double,
    val previousPrice: Double,
)