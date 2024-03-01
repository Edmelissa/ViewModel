package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClickerViewModel : ViewModel() {

    private val _hedgehogScoreLiveData = MutableLiveData(0)
    val hedgehogScoreLiveData: LiveData<Int> = _hedgehogScoreLiveData

    private val _shrimpScoreLiveData = MutableLiveData(0)
    val shrimpScoreLiveData: LiveData<Int> = _shrimpScoreLiveData

    private val _jellyfishScoreLiveData = MutableLiveData(0)
    val jellyfishScoreLiveData: LiveData<Int> = _jellyfishScoreLiveData

    private val _imageButtonSrcLiveData = MutableLiveData(R.drawable.hedgehog_svg)
    var imageButtonSrcLiveData: LiveData<Int> = _imageButtonSrcLiveData

    fun incrementHedgehogScore(){
        _hedgehogScoreLiveData.postValue(_hedgehogScoreLiveData.value?.plus(1) ?: 0)
    }

    fun incrementShrimpScore(){
        _shrimpScoreLiveData.postValue(_shrimpScoreLiveData.value?.plus(1) ?: 0)
    }

    fun incrementJellyfishScore(){
        _jellyfishScoreLiveData.postValue(_jellyfishScoreLiveData.value?.plus(1) ?: 0)
    }

    fun changeImageButton(newImage : Int){
        _imageButtonSrcLiveData.postValue(newImage)
    }
}