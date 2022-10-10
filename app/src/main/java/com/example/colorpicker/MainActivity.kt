package com.example.colorpicker

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {

    lateinit var btnColor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnColor = findViewById(R.id.btnColor)
        btnColor.setOnClickListener {
            // spinner
        }
    }
}