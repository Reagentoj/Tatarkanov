package com.example.tatarkanovkantemir.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tatarkanovkantemir.model.Film
import com.example.tatarkanovkantemir.utils.Const

@Database(entities = [Film::class], version = Const.DB_VERSION)
abstract class MoviesDB : RoomDatabase() {

    abstract fun getMoviesDao(): Dao

    companion object {
        private var db: MoviesDB? = null

        fun instance(context: Context): MoviesDB{
            return if (db == null){
                db = Room.databaseBuilder(context, MoviesDB::class.java, "db").build()
                db as MoviesDB
            } else {
                db as MoviesDB
            }
        }
    }
}