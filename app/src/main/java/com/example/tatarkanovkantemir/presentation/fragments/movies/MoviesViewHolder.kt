package com.example.tatarkanovkantemir.presentation.fragments.movies

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tatarkanovkantemir.R

class MoviesViewHolder(view: View) : ViewHolder(view) {
    val title: TextView = view.findViewById(R.id.movieTitle)
    val date: TextView = view.findViewById(R.id.date)
    val poster: ImageView = view.findViewById(R.id.moviePoster)
    val addToFavorite: ImageView = view.findViewById(R.id.addToFavorite)
}