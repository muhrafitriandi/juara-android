package com.yandey.tiptime.utils

import android.content.Context
import android.widget.Toast

object AppUtils {
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}