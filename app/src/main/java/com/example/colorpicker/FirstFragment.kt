package com.example.colorpicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvYourColor = view.findViewById<TextView>(R.id.tvYourColor)
        val data = arguments

        val selectedColorCode = data!!.getParcelable<ColorCode>("bundleColorCode")

        val code = selectedColorCode!!.code
        val intColor = selectedColorCode.color // color integer

        val actualColor = ContextCompat.getColor(requireContext(), intColor) // convert into usable color

        tvYourColor.text = code
        tvYourColor.setTextColor(actualColor)

        // TODO: implement color
    }
}