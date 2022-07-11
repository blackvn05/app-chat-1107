package com.ssn.appchat.ui.testStream

import android.os.Bundle
import android.util.Log
import com.ssn.appchat.R
import com.ssn.appchat.constants.Tags
import com.ssn.appchat.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class TestStream : BaseActivity() {

    override val viewModel: TestStreamViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Log.d(Tags.DEBUG,viewModel.itIs)
        Log.d(Tags.DEBUG,viewModel.name)
//        showLoading()
    }


}
