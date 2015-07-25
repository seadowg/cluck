package com.seadowg.cluck.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

import com.seadowg.cluck.R
import com.seadowg.cluck.view.ErrorDialog

public class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.timer)

        findViewById(R.id.start_button).setOnClickListener { onSubmitWeight() }
        findViewById(R.id.reset_button).setOnClickListener { onReset() }
    }

    private fun onSubmitWeight() {
        try {
            val weight = Integer.parseInt((findViewById(R.id.weight) as TextView).getText().toString())
            val totalMinsToCook = Math.round((weight / 450f) * 20f) + 10
            val hoursToCook = totalMinsToCook / 60
            val minsToCook = totalMinsToCook % 60

            val remaining = findViewById(R.id.remaining) as TextView
            remaining.setText(hoursToCook.toString() + ":" + "%02d".format(minsToCook))

            findViewById(R.id.running).setVisibility(View.VISIBLE)
            findViewById(R.id.not_running).setVisibility(View.GONE)
        } catch (e: NumberFormatException) {
            val error = ErrorDialog(this, getString(R.string.no_weight_error))
            error.show()
        }

    }

    private fun onReset() {
        findViewById(R.id.running).setVisibility(View.GONE)
        findViewById(R.id.not_running).setVisibility(View.VISIBLE)
    }
}
