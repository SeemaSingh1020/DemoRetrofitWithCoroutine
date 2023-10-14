package com.neardoctor.view

import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Extension function for showing a Toast message in the context.
 *
 * @param message The message to be displayed in the Toast.
 */

fun Context.showMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/**
 * Extension function for obtaining an Intent for a specific class from a given context.
 *
 * @param context The context used to create the Intent.
 * @return An Intent for the specified class.
 */

fun Class<*>.getIntent(context: Context): Intent {
    return Intent(context, this)
}

/**
 * Extension function for starting an activity for a given class in a specific context.
 *
 * @param cls The class of the activity to be started.
 */

fun Context.startActivity(cls: Class<*>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}

