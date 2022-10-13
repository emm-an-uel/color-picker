package com.example.colorpicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.security.auth.Subject

class MainActivity : AppCompatActivity() {

    lateinit var btnConfirm: Button
    lateinit var colorCodeList: ArrayList<ColorCode>
    lateinit var subjectList: ArrayList<String>
    lateinit var tableLayout: TableLayout

    lateinit var spinnerIdList: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tableLayout = findViewById(R.id.tableLayout)

        initColorCodeList()

        setupSpinners()

        setupBtnConfirm()
    }

    private fun initColorCodeList() {
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

    private fun setupSpinners() {
        subjectList = arrayListOf("Subject 1", "Subject 2", "Subject 3")
        spinnerIdList = arrayListOf()

        for (subject in subjectList) {
            // adding a subject textview
            val tableRow = TableRow(this)

            val tvSubject = TextView(this)
            tvSubject.text = subject
            tvSubject.textSize = 22f

            tvSubject.setPadding(30, 30, 10, 0)

            tableRow.addView(tvSubject)

            // adding a spinner
            val spinner = Spinner(this)
            spinner.id = View.generateViewId()
            spinnerIdList.add(spinner.id)
            val adapter = SpinnerAdapter(this, colorCodeList)
            spinner.adapter = adapter

            spinner.layoutParams = TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT,
                1f
            )

            spinner.setPadding(20, 15, 0, 0)

            tableRow.addView(spinner)

            tableLayout.addView(tableRow)
        }
    }

    private fun setupBtnConfirm() {
        btnConfirm = findViewById(R.id.btnConfirm)

        btnConfirm.setOnClickListener {
            saveSubjectColorPair()
        }
    }

    private fun saveSubjectColorPair() {

        val subjectColorList: ArrayList<SubjectColor> = arrayListOf()

        val numSpinners = spinnerIdList.size

        var n = 0
        while (n < numSpinners) {
            val spinnerId = spinnerIdList[n]
            val spinner = findViewById<Spinner>(spinnerId)

            val colorCodeIndex = spinner.selectedItemPosition
            val colorCode = colorCodeList[colorCodeIndex]
            val color = colorCode.color

            val subject = subjectList[n]

            val subjectColor = SubjectColor(subject, color)
            subjectColorList.add(subjectColor)

            n++
        }

        val fragment = FirstFragment()
        val bundle = Bundle()
        bundle.putParcelableArrayList("bundleSubjectColor", subjectColorList)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }
}