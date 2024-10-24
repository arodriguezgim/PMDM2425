package org.iesch.a08_retrofit_dogs.data

import com.google.gson.annotations.SerializedName

// 1
data class DogsResponse(
    @SerializedName("status") var status: String,
    @SerializedName("message") var imagesList: List<String>
)