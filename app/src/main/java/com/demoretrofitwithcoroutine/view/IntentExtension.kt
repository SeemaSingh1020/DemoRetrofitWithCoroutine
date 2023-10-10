package com.demoretrofitwithcoroutine.view

import android.content.Context
import android.widget.Toast

fun Context.showMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}