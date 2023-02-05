package com.example.tatarkanovkantemir.data.room
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tatarkanovkantemir.model.Film

@Dao
interface Dao {

    @Insert
    suspend fun insert(film: Film)

    @Delete
    suspend fun delete(film: Film)

    @Query("SELECT * FROM moviesTable")
    fun getMovies(): LiveData<List<Film>>
}
