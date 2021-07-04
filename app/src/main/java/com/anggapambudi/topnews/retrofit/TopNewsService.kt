package com.anggapambudi.topnews.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TopNewsService {

    private const val BASE_URL = "https://newsapi.org/v2/"

    val instance: TopNewsEndPoint by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(TopNewsEndPoint::class.java)
    }

}