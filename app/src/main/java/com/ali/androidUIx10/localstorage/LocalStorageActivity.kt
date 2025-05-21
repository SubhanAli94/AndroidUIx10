package com.ali.androidUIx10.localstorage

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ali.androidUIx10.R
import com.ali.androidUIx10.databinding.ActivityLocalStorageBinding

class LocalStorageActivity : AppCompatActivity() {
    // ViewBinding instance for activity_main.xml
    private lateinit var binding: ActivityLocalStorageBinding

    // Database helper instance
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLocalStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize DatabaseHelper
        dbHelper = DatabaseHelper(this)

        // Set click listener for "Save Name"
        binding.buttonSave.setOnClickListener {
            val nameInput = binding.editTextName.text.toString().trim()

            if (nameInput.isEmpty()) {
                // Show a short message if nothing is entered
                Toast.makeText(this, "Please enter a name first", Toast.LENGTH_SHORT).show()
            } else {
                // Insert name into SQLite
                val newRowId = dbHelper.insertName(nameInput)
                if (newRowId == -1L) {
                    Toast.makeText(this, "Error saving name", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Name saved with ID: $newRowId", Toast.LENGTH_SHORT).show()
                    // Clear the EditText after saving
                    binding.editTextName.text?.clear()
                }
            }
        }

        binding.buttonViewAll.setOnClickListener {
            val intent = Intent(this, LocalStorageActivity2::class.java)

            // Create an ActivityOptions bundle with our slide animations
            val options = ActivityOptions.makeCustomAnimation(
                this,
                R.anim.slide_in_right,  // enter animation for SecondActivity
                R.anim.slide_out_left   // exit animation for MainActivity
            )

            // Launch SecondActivity using the ActivityOptions bundle
            startActivity(intent, options.toBundle())
        }
    }
}