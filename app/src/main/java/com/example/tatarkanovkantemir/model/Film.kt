package com.example.tatarkanovkantemir.model

import androidx.room.*
import com.example.tatarkanovkantemir.data.room.CountriesConverter
import com.example.tatarkanovkantemir.data.room.GenresConverter

@Entity(tableName = "moviesTable")
@TypeConverters(GenresConverter::class)
data class Film(
    @PrimaryKey(autoGenerate = true)
    val filmId: Int,
    val countries: List<Country>,
    val genres: List<Genre>,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val year: String,
)

