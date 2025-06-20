package com.example.lab5_9

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var pageCountEditText: EditText
    private lateinit var discountSeekBar: SeekBar
    private lateinit var discountLabel: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pageCountEditText = findViewById(R.id.pageCountEditText)
        discountSeekBar = findViewById(R.id.discountSeekBar)
        discountLabel = findViewById(R.id.discountLabel)
        calculateButton = findViewById(R.id.calculateButton)

        discountSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                discountLabel.text = "Скидка: $progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        calculateButton.setOnClickListener {
            val pageCount = pageCountEditText.text.toString().toIntOrNull()
            val discount = discountSeekBar.progress

            if (pageCount == null || pageCount <= 0) {
                Toast.makeText(this, "Введите количество страниц", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pricePerPage = 5
            val total = pageCount * pricePerPage
            val discountedTotal = total * (1 - discount / 100.0)

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("orderTotal", discountedTotal)
            startActivity(intent)
        }
    }
}