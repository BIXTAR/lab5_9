package com.example.lab5_9

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val total = intent.getDoubleExtra("orderTotal", 0.0)

        resultTextView.text = "Сумма заказа = %.2f руб.".format(total)
    }
}