package com.example.tatarkanovkantemir.utils

import android.content.Context
import android.net.ConnectivityManager


object InternetConnection {

    fun checkConnection(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork
        if (network != null) {
            return true
        }
        return false
    }
}