package com.example.botenesrecycleview

import com.example.botenesrecycleview.models.RellenoWrapper
import retrofit2.Call
import retrofit2.http.GET

interface PupusasApiService {
        @GET("rellenos")
        fun getRellenos() : Call<RellenoWrapper>

//    @POST("orden")
//    fun submitOrden(@Body params: Orden) : Call<Orden>

}