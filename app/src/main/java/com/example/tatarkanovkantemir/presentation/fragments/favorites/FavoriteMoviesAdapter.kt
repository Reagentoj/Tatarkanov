package com.example.tatarkanovkantemir.presentation.fragments.favorites

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tatarkanovkantemir.R
import com.example.tatarkanovkantemir.model.Film
import com.example.tatarkanovkantemir.presentation.fragments.movies.MoviesViewHolder
import com.example.tatarkanovkantemir.utils.OnMovieClick
import com.squareup.picasso.Picasso

class FavoriteMoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {

    private var moviesList = emptyList<Film>()
    var isFavorite = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.title.text = moviesList[position].nameRu
        holder.date.text = moviesList[position].year
        Picasso.with(holder.itemView.context)
            .load(moviesList[position].posterUrlPreview)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.poster)
        holder.addToFavorite.setOnClickListener{
            if (!isFavorite){
                holder.addToFavorite.setImageResource(R.drawable.baseline_star_24)
                isFavorite = true
            } else {
                holder.addToFavorite.setImageResource(R.drawable.baseline_star_outline_24)
                isFavorite = false

            }

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Film>) {
        moviesList = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MoviesViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            OnMovieClick.onClickFromFavoriteFragment(moviesList[holder.adapterPosition])
        }

    }

    override fun onViewDetachedFromWindow(holder: MoviesViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

}