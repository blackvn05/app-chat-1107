package com.ssn.appchat.di


import com.ssn.appchat.ui.testStream.TestStreamViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val models = module {

    viewModel {
        TestStreamViewModel()
    }
}


val modules = listOf(models,dialogs)