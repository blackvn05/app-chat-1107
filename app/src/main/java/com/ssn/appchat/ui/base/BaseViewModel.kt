package com.ssn.appchat.ui.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.*

abstract class BaseViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val itIs = "BaseViewModel"

    fun hideLoading() {
        isLoading.value = false
    }

    fun showLoading() {
        isLoading.value = true
    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
    }


}