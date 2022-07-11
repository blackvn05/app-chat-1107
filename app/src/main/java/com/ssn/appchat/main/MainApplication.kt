package com.ssn.appchat.main

import android.app.Application
import com.google.firebase.FirebaseApp

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    companion object {
        private var instance: MainApplication? = null

        fun getInstanceApp(): MainApplication {
            return instance as MainApplication
        }
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication) //
            modules(com.ssn.appchat.di.modules) // Khai báo tất cả các modules để sử dụng
        }
//        FirebaseApp.initializeApp(this)
    }
}
