package com.ssn.appchat.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.Window
import com.ssn.appchat.R
import com.ssn.appchat.constants.Tags
import com.ssn.appchat.views.CircleProgressBar
import org.koin.core.KoinApplication.Companion.init

class LoadingDialog(context: Context) : Dialog(context) {
    var progress: CircleProgressBar? = null
    private var handler: Handler? = null
    private var run: Runnable? = null
    private var dialog: Dialog? = null

    init {
        init()
    }

    private fun init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
        handler = Handler()
        dialog = this
        run = Runnable {
            try {
                if (dialog != null && isShowing) {
                    dismiss()
                }
            } catch (e: Exception) {
                Log.d(Tags.DEBUG, e.toString())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
        progress = findViewById<View>(R.id.progressLoading) as CircleProgressBar
    }

    override fun onStop() {
        super.onStop()
    }

    fun setCancel(isCancel: Boolean) {
        setCancelable(isCancel)
        setCanceledOnTouchOutside(isCancel)
    }

    override fun show() {
        super.show()
        handler!!.postDelayed(run!!, 90000)
    }

    override fun dismiss() {
        try {
            super.dismiss()
            handler!!.removeCallbacks(run!!)
        } catch (ex: java.lang.Exception) {
            Log.d(Tags.DEBUG, ex.toString())
        }
    }
}