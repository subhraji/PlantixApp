package com.example.myapplication.model.repository.about_canada

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.network.ApiClient
import com.example.myapplication.model.pojo.AboutCanada
import com.example.myapplication.model.repository.Outcome

class AboutCanadaRepositoryImpl(private val context: Context): AboutCanadaRepository {

    private val apiService = ApiClient.getInstance(context)

    override suspend fun getAboutCanada(): Outcome<AboutCanada> {
        val apiResponse = MutableLiveData<Outcome<AboutCanada>>()
        try {
            val response = apiService.getAboutCanada()
            apiResponse.value = Outcome.success(response!!)
        } catch (e: Throwable) {
            apiResponse.value = Outcome.failure(e)
        }

        return apiResponse.value as Outcome<AboutCanada>
    }
}