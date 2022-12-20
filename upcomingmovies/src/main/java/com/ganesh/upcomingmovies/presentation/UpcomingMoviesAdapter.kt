package com.ganesh.upcomingmovies.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.ganesh.upcomingmovies.R

class UpcomingMoviesAdapter(
    private var movieItems: List<UpcomingMovieItemViewData>,
    private val onMovieClick: (movieItem: UpcomingMovieItemViewData) -> Unit
) : RecyclerView.Adapter<UpcomingMoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_upcoming_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movieItems.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieItems[position])
    }

    fun appendMovies(movieItems: List<UpcomingMovieItemViewData>) {
        this.movieItems = movieItems
        notifyItemRangeInserted(
            this.movieItems.size,
            movieItems.size - 1
        )
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val poster: ImageView = itemView.findViewById(R.id.item_movie_poster)

        fun bind(movieItem: UpcomingMovieItemViewData) {
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movieItem.posterPath}")
                .transform(CenterCrop())
                .into(poster)

            itemView.setOnClickListener { onMovieClick.invoke(movieItem) }
        }
    }
}
