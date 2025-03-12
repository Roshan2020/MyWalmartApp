package com.mysampleapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/")  // Replace with actual base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}