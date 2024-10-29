package org.iesch.a11_splash_cine_halloween.model

// 2 - Configuramos nuestro modelo de datos
data class Movie(
    val id: Int,
    val title: String,
    val poster_path: String
)

data class MovieResponse(
    val results: List<Movie>
)