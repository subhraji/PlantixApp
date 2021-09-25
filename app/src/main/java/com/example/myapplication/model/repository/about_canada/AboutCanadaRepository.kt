package com.example.myapplication.model.repository.about_canada

import com.example.myapplication.model.pojo.AboutCanada
import com.example.myapplication.model.repository.Outcome

interface AboutCanadaRepository {
    suspend fun getAboutCanada(): Outcome<AboutCanada>
}