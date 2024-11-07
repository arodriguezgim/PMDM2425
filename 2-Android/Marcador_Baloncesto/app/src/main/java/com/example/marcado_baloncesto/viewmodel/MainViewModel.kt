package com.example.marcado_baloncesto.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var localScore = MutableLiveData<Int>()
    var visitorScore = MutableLiveData<Int>()
    // Cuando iniciamos ViewModel se ejecuta este método
    // de manera que nos aseguramos que los valores no sean nulos
    init {
        resetScores()
    }

    fun resetScores() {
        localScore.value = 0
        visitorScore.value = 0
    }

    fun addPointsToScore(points: Int, isLocal: Boolean) {
        if (isLocal) {
            localScore.value = localScore.value?.plus(points)
        } else {
            visitorScore.value = visitorScore.value!! + points
        }
    }

    fun decreaseLocalScore(){
        if (localScore.value!! > 0){
            localScore.value = localScore.value?.minus(1)
        }
    }
    fun decreaseVisitorScore(){
        if (visitorScore.value!! > 0){
            visitorScore.value = visitorScore.value!! -1
        }
    }
}