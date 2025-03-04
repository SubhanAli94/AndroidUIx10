package com.ali.androidUIx10

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar


class UIControlsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_uicontrols)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toastButton: Button = findViewById(R.id.toastButton)
        val snackbar: Button = findViewById(R.id.snackbar)
        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)
        val checkBox: CheckBox = findViewById(R.id.checkbox)
        val alertDialogButton: Button = findViewById(R.id.alertDialogButton)
        val spinner: Spinner = findViewById(R.id.spinner)
        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        val datePicker: DatePicker = findViewById(R.id.datePicker)
        val timePicker: TimePicker = findViewById(R.id.timePicker)

        toastButton.setOnClickListener {
            Toast.makeText(this, "Simple Toast Message", Toast.LENGTH_SHORT).show()
        }

        snackbar.setOnClickListener {
            val sb = Snackbar.make(findViewById(R.id.main), "This is a Snackbar", Snackbar.LENGTH_INDEFINITE)
            sb.setAction("Dismiss") { v: View? ->  sb.dismiss() }
            sb.show()
        }

        alertDialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alert")
                .setMessage("Are you sure?")
                .setPositiveButton("OK") { _, _ -> }
                .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf("Option 1", "Option 2", "Option 3"))
        spinner.adapter = adapter

        val autoCompleteAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listOf("Apple", "Banana", "Cherry"))
        autoCompleteTextView.setAdapter(autoCompleteAdapter)
    }
}