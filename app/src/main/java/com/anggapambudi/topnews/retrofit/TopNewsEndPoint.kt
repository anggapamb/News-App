package com.anggapambudi.topnews.retrofit

import com.anggapambudi.topnews.model.GetTopNewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface TopNewsEndPoint {

    @GET("top-headlines?country=id&apiKey=4d60f530366546b48e40be3f5921b762")
    fun getTopNews(): Call<GetTopNewsResponse>

}