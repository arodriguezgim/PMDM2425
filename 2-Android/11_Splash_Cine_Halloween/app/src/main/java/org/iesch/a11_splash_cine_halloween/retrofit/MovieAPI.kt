package org.iesch.a11_splash_cine_halloween.retrofit

import org.iesch.a11_splash_cine_halloween.model.MovieResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "es-ES",
        @Query("page") page: Int = 1
    ) : MovieResponse


    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        fun create() : MovieAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(MovieAPI::class.java)
        }
    }
}



