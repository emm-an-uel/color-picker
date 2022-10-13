package com.example.colorpicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    lateinit var spinnerColor: Spinner
    lateinit var btnConfirm: Button
    lateinit var colorCodeList: ArrayList<ColorCode>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initColorArray()

        setupSpinnerColor()
        setupBtnConfirm()
    }

    private fun initColorArray() {
        colorCodeList = arrayListOf()

        val colorMap = mutableMapOf<String, Int>()

        colorMap.apply {
            put("Blue", R.color.blue)
            put("Red", R.color.red)
            put("Yellow", R.color.yellow)
            put("Green", R.color.green)
            put("Pink", R.color.pink)
        }

        for ((code, color) in colorMap) { // convert code, color into ColorCode and add to colorCodeList
            val colorCode = ColorCode(code, color)
            colorCodeList.add(colorCode)
        }
    }

    private fun setupSpinnerColor() {

        spinnerColor = findViewById(R.id.spinner)
        val adapter = SpinnerAdapter(this, colorCodeList)
        spinnerColor.adapter = adapter
    }

    private fun setupBtnConfirm() {
        btnConfirm = findViewById(R.id.btnConfirm)

        btnConfirm.setOnClickListener {
            val color = spinnerColor.selectedItem.toString()
            // TODO: pass color as color and show in fragment_first
        }
    }
}