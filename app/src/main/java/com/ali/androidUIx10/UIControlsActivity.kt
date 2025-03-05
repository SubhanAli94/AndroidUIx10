package com.ali.androidUIx10

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar


class UIControlsActivity : AppCompatActivity() {

    var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_uicontrols)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toastButton = findViewById<Button>(R.id.toastButton)
        toastButton.setOnClickListener {
            count++
            Toast.makeText(this, "Added 1 to counter. Total count is: $count", Toast.LENGTH_SHORT)
                .show()
        }

        val snackbar = findViewById<Button>(R.id.snackbar)
        snackbar.setOnClickListener {
            val sb = Snackbar.make(
                findViewById(R.id.main),
                "Total count is: $count",
                Snackbar.LENGTH_INDEFINITE
            )
            sb.setAction("Dismiss") { v: View? ->
                sb.dismiss()
            }
            sb.show()
        }

        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)
        val imgLight = findViewById<ImageView>(R.id.img_light)
        toggleButton.setOnClickListener {
            if (toggleButton.isChecked) {
                DrawableCompat.setTint(imgLight.drawable, getColor(R.color.yellow))
            } else {
                DrawableCompat.setTint(imgLight.drawable, getColor(R.color.black))
            }
        }

        val checkBox: CheckBox = findViewById(R.id.checkbox)
        val ll_light = findViewById<LinearLayout>(R.id.ll_light)
        checkBox.setOnClickListener {
            if (checkBox.isChecked) {
                ll_light.visibility = View.VISIBLE
            } else {
                ll_light.visibility = View.GONE
            }
        }

        val alertDialogButton: Button = findViewById(R.id.alertDialogButton)
        alertDialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Reset Counter And Light Status")
                .setMessage("Are you sure you want to reset?")
                .setPositiveButton("Yes") { dialog, _ ->
                    count = 0
                    toggleButton.isChecked = false
                    Toast.makeText(this, "Reset successfully", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    //if (which == DialogInterface.BUTTON_POSITIVE)
                }
                .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listOf("Option 1", "Option 2", "Option 3")
        )
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        val autoCompleteAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            listOf("Apple", "Banana", "Cherry")
        )

        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        autoCompleteTextView.setAdapter(autoCompleteAdapter)

        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        ratingBar.setOnRatingBarChangeListener() { ratingBar, fl, b ->
            Toast.makeText(this, "Rating: $fl", Toast.LENGTH_SHORT).show()
        }

        val datePicker: DatePicker = findViewById(R.id.datePicker)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
                // Handle the date change
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                // Do something with the selected date
                println("Selected Date: $selectedDate")
            }
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val timePicker: TimePicker = findViewById(R.id.timePicker)
        timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
            val selectedTime = "$hourOfDay:$minute"
            println("Selected Time: $selectedTime")

            progressBar.progress = minute
        }

    }
}
