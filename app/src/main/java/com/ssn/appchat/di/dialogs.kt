package com.ssn.appchat.di

import com.ssn.appchat.dialogs.LoadingDialog
import org.koin.dsl.module


//val dialogs = { // không được khai báo như này nếu k sẽ bị lỗi
//    createLoadingDialog()
//}

val dialogs = module {
    factory { createLoadingDialog() }
}


fun createLoadingDialog(): LoadingDialog {
    return LoadingDialog(Common.currentActivity!!)
}