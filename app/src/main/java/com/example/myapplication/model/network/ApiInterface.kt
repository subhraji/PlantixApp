package com.example.myapplication.model.network

import com.example.myapplication.model.pojo.AboutCanada
import retrofit2.http.GET

interface ApiInterface {

    @GET("/s/2iodh4vg0eortkl/facts.json")
    suspend fun getAboutCanada(): AboutCanada?
}