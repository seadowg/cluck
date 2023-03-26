package com.seadowg.cluck.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import com.seadowg.cluck.R
import com.seadowg.cluck.view.ErrorDialog
import com.seadowg.cluck.view.setUpEdgeToEdge
import kotlin.math.roundToInt

class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpEdgeToEdge(fitsSystemWindow = true)

        setContentView(R.layout.timer)

        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener { onSubmitWeight() }
        val resetButton = findViewById<Button>(R.id.reset_button)

        resetButton.setOnClickListener { onReset() }
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
