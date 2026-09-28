package br.edu.ifal.aulaprmo.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Accommodation(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val total: Double,
    val rating: Double,
    val dates: String,
    val location: String,
    val host: String,
    val imageUrl: String,
)