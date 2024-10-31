package org.iesch.a11_splash_cine_halloween.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.iesch.a11_splash_cine_halloween.R
import org.iesch.a11_splash_cine_halloween.model.Movie

class MovieAdapter( private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val titleTextView : TextView = view.findViewById(R.id.movieTitle)
        val posterImageView : ImageView = view.findViewById(R.id.moviePoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleTextView.text = movie.title
        Picasso.get().load("https://image.tmdb.org/t/p/w500/${movie.poster_path}")
            .into(holder.posterImageView)
    }
}