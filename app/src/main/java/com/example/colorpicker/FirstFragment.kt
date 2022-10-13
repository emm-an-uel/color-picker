package com.example.colorpicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat

class FirstFragment : Fragment() {

    lateinit var mapSubjectColor: MutableMap<String, Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMapSubjectColor()

        colorCodeTextViews()
    }

    private fun initMapSubjectColor() {
        val data = arguments
        val subjectColorList = data!!.getParcelableArrayList<SubjectColor>("bundleSubjectColor")

        mapSubjectColor = mutableMapOf()

        for (subjectColor in subjectColorList!!) {
            val subject = subjectColor.subject
            val color = subjectColor.color

            mapSubjectColor.put(subject, color)
        }
    }

    private fun colorCodeTextViews() {
        val tv1 = requireView().findViewById<TextView>(R.id.tv1)
        val tv2 = requireView().findViewById<TextView>(R.id.tv2)
        val tv3 = requireView().findViewById<TextView>(R.id.tv3)
        val tv4 = requireView().findViewById<TextView>(R.id.tv4)

        val listTextViews = listOf<TextView>(tv1, tv2, tv3, tv4)

        for (tv in listTextViews) {
            val subject = tv.text.toString()

            if (mapSubjectColor.containsKey(subject)) {
                val intColor = mapSubjectColor[subject]
                val actualColor = ContextCompat.getColor(requireContext(), intColor!!) // convert into usable color
                tv.setTextColor(actualColor)
            }
        }
    }
}