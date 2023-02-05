package com.example.tatarkanovkantemir.data.room

import androidx.room.TypeConverter
import java.util.stream.Collectors

class CountriesConverter {

    @TypeConverter
    fun fromCountries(countries: List<String>): String? {
        return countries.stream().collect(Collectors.joining(", "))
    }

}