package com.example.colorpicker

import android.content.Context
import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat

class SpinnerAdapter(context: Context, colorCodeList: ArrayList<ColorCode>)
    : ArrayAdapter<ColorCode>(context, 0, colorCodeList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return myView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return myView(position, convertView, parent)
    }

    private fun myView(position: Int, convertView: View?, parent: ViewGroup): View {

        val colorCode = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.spinner_item,
            parent,
            false
        )

        colorCode?.let {
            val tvCode = view.findViewById<TextView>(R.id.tvCode)
            val ivColor = view.findViewById<ImageView>(R.id.ivColor)

            if (colorCode.code != null) {

                tvCode.text = colorCode.code
                ivColor.setColorFilter(ContextCompat.getColor(context, colorCode.color))
            }
        }

        return view
    }
}