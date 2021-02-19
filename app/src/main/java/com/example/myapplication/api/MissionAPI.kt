package com.example.myapplication.api


import com.example.myapplication.model.Mission
import retrofit2.Call

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MissionAPI {

   // @GET("v3/launches/")
   // suspend fun getMissions(@Query("limit") limit:Int):Response<List<Mission>>

    @GET("v3/launches/")
    fun getMissions(@Query("limit") limit:Int): Call<List<Mission>>
}