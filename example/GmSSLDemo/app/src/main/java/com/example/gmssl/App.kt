package com.example.gmssl

import android.app.Application

class App : Application() {
    init {
//        System.loadLibrary("crypto")
//        System.loadLibrary("ssl")
        System.loadLibrary("native-lib")
    }
}