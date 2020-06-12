package com.seadowg.cluck.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.seadowg.cluck.R
import com.seadowg.cluck.view.ErrorDialog
import kotlin.math.roundToInt

public class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer)

        findViewById<Button>(R.id.start_button).setOnClickListener { onSubmitWeight() }
        findViewById<Button>(R.id.reset_button).setOnClickListener { onReset() }
    }

    private fun onSubmitWeight() {
        try {
            val weight = Integer.parseInt((findViewById<TextView>(R.id.weight)).text.toString())
            val totalMinsToCook = ((weight / 450f) * 20f).roundToInt() + 10
            val hoursToCook = totalMinsToCook / 60
            val minsToCook = totalMinsToCook % 60

            val remaining = findViewById<TextView>(R.id.remaining)
            remaining.text = hoursToCook.toString() + ":" + "%02d".format(minsToCook)

            findViewById<View>(R.id.running).visibility = View.VISIBLE
            findViewById<View>(R.id.not_running).visibility = View.GONE
        } catch (e: NumberFormatException) {
            val error = ErrorDialog(this, getString(R.string.no_weight_error))
            error.show()
        }

    }

    private fun onReset() {
        findViewById<View>(R.id.running).visibility = View.GONE
        findViewById<View>(R.id.not_running).visibility = View.VISIBLE
    }
}
