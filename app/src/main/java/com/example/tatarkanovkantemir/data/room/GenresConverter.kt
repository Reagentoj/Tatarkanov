package com.example.tatarkanovkantemir.data.room

import androidx.room.TypeConverter
import com.example.tatarkanovkantemir.model.Country
import com.example.tatarkanovkantemir.model.Genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*
import java.util.stream.Collectors

class GenresConverter {

    private val gson = Gson()
    @TypeConverter
    fun genresToListServer(data: String?): List<Genre?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<Genre?>?>() {}.type
        return gson.fromJson<List<Genre?>>(data, listType)
    }

    @TypeConverter
    fun genreToString(someObjects: List<Genre?>?): String? {
        return gson.toJson(someObjects)
    }
    @TypeConverter
    fun countriesToListServer(data: String?): List<Country?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<Country?>?>() {}.type
        return gson.fromJson<List<Country?>>(data, listType)
    }

    @TypeConverter
    fun countryToString(someObjects: List<Country?>?): String? {
        return gson.toJson(someObjects)
    }
}