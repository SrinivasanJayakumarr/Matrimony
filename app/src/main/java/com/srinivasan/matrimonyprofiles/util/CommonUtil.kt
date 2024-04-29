package com.srinivasan.matrimonyprofiles.util

import android.content.Context
import android.widget.Toast

object CommonUtil {

    fun showShortToast(context: Context, message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun showLongToast(context: Context, message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

}