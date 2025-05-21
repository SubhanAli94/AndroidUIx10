package com.ali.androidUIx10.localstorage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.androidUIx10.R
import com.ali.androidUIx10.databinding.ActivityLocalStorage2Binding

class LocalStorageActivity2 : AppCompatActivity() {

    // ViewBinding instance for activity_second.xml
    private lateinit var binding: ActivityLocalStorage2Binding

    // Database helper
    private lateinit var dbHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout via ViewBinding
        binding = ActivityLocalStorage2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize DatabaseHelper
        dbHelper = DatabaseHelper(this)


        val cursor = dbHelper.fetchAllNames()

        // Build a String of names from the Cursor
        val stringBuilder = StringBuilder()

        if (cursor.moveToFirst()) {
            do {
                // Column index 0 = _id, 1 = name
                val nameColumnIndex = cursor.getColumnIndexOrThrow(
                    DatabaseHelper.COLUMN_NAME
                )
                val name = cursor.getString(
                    nameColumnIndex
                )

                stringBuilder.append("• ").append(name).append("\n")
            } while (cursor.moveToNext())
        } else {
            stringBuilder.append("(No names saved yet.)")
        }
        cursor.close() // Always close the Cursor!

        // Display all names in the TextView
        binding.textViewAllNames.text = stringBuilder.toString()

        // Set click listener for the Back button
        binding.buttonBack.setOnClickListener {
            finish() // End this activity and return to LocalStorageActivity
        }
    }
}