package com.seadowg.cluck.view

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.seadowg.cluck.R

class ErrorDialog(context: Context, message: String) {
    val error = AlertDialog.Builder(context)
            .setMessage(message)
            .setPositiveButton(R.string.ok) { dialogInterface, i -> dialogInterface.dismiss()
            }.create()

    fun show() {
        error.show()
    }
}
