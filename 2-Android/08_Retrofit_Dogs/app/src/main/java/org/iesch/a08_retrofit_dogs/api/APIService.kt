package org.iesch.a08_retrofit_dogs.api

import org.iesch.a08_retrofit_dogs.data.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

//2 La interfaz creará el método/ los métodos por el cual consumiremos nuestra API
interface APIService {

    @GET
    suspend fun getDogsByBreed(@Url url:String ) : Response<DogsResponse>
}