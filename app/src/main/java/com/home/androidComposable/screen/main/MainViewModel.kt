package com.home.androidComposable.screen.main

import androidx.lifecycle.ViewModel
import com.home.androidComposable.data.fakeData

class MainViewModel : ViewModel() {
    fun getFakeData() = fakeData()
}