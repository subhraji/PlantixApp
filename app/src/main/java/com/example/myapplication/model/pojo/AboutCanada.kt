package com.example.myapplication.model.pojo


import com.google.gson.annotations.SerializedName

data class AboutCanada(
    @SerializedName("rows")
    val rows: List<Row>,
    @SerializedName("title")
    val title: String
)