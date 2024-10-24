package org.iesch.a09_corrutinas_kotlin.retrofit

import org.iesch.a09_corrutinas_kotlin.api.ApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitHelper {

    private const val URL = "https://www.superheroapi.com/"

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getInstance() : ApiServices {
        return  retrofit.create(ApiServices::class.java)
    }
}