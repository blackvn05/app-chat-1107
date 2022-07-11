package com.ssn.appchat.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.ssn.appchat.R
import com.ssn.appchat.di.Common
import com.ssn.appchat.dialogs.LoadingDialog
import org.koin.android.ext.android.inject


abstract class BaseActivity : AppCompatActivity() {
    private val loading by inject<LoadingDialog>()
    abstract val viewModel: BaseViewModel

    /*
        Tạo ra base activity kế thừa từ appCompatActivity
        loadingDialog chưa thể dùng được nếu chưa khai báo trong thư mục di và add vào modules
        Khai báo MainApplication vào  AndroidManifest.xml :application <android:name=".main.MainApplication">
    */

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        Common.currentActivity = this // Cũng cấp activity hiện tại để hiển thị dialog

        viewModel.apply {
            isLoading.observe(this@BaseActivity) {
                handleShowLoading(it)
            }
        }
    }


    //Lưu và phục hồi trạng thái của Activity trong Android
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onResume() {
        super.onResume()
    }

    fun onError(it: String?) {
        // show dialog error
    }

    fun hideLoading() {
        loading.dismiss()
    }

    fun showLoading() {
        loading.show()
    }

    open fun handleShowLoading(isLoading: Boolean) {
        runOnUiThread {
            if (isLoading) showLoading() else hideLoading()
        }
    }
}