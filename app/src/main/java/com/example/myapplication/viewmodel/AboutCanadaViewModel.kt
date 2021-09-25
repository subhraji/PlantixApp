package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.model.repository.about_canada.AboutCanadaRepository

class AboutCanadaViewModel(private val mAboutCanadaRepository: AboutCanadaRepository): ViewModel() {
    fun getAboutCanada() = liveData {
        emit(mAboutCanadaRepository.getAboutCanada())
    }
}