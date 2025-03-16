package com.ali.androidUIx10.navigations

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.androidUIx10.R


/*
    - Activity: An Activity is a crucial component in an Android app that provides the user
     interface. It acts as a single, focused screen where users interact with the app. The
     `MainActivity` is the entry point of the app and is responsible for hosting the navigation
     structure.

    - Fragment: A Fragment represents a modular section of the UI inside an Activity. Fragments
     help create flexible and reusable UI components that can be combined within an Activity to
     support multiple screen sizes and layouts.

    - Navigation: Instead of switching between Activities, modern Android apps primarily use
     Fragments within an Activity, managed via the Navigation Component, to improve performance
     and maintainability.

    - Custom Views: Custom Views allow creating reusable UI components with consistent
     styling and behavior.

    - Dialogs: A Dialog is a small window that prompts the user to take an action or enter
     information before continuing.
*/

class AppNavigations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Content can go behind sys bars (Status Bar and Nav Bar)
        setContentView(R.layout.activity_app_navigations)

        /*insets: Areas of the screen that are obscured or partially covered by system UI elements
            These are Status Bar, Navigation Bar, Keyboard etc.
         */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            //Set padding to view by the amount of space occupied on either edge of the screen.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}