package com.example.gmssl

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlinx.android.synthetic.main.dialog_input.*

class InputDialog(context: Context) : Dialog(context) {

    private val handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            throw RuntimeException()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_input)
        setCanceledOnTouchOutside(false)

        button2.setText(android.R.string.ok)
        button2.setOnClickListener {
            handler.sendMessage(handler.obtainMessage())
            dismiss()
        }

        setOnShowListener { et_content.setText("") }
    }

    override fun show() {
        super.show()
        try {
            Looper.loop()
        } catch (e: RuntimeException) {
        }
    }

    fun getInput() = et_content.text.toString()
}