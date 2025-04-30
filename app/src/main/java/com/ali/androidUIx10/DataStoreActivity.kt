package com.ali.androidUIx10

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

//androidx.datastore:datastore-preferences


/*
A delegate in Kotlin is an object that manages a property’s initialization,
getter, and setter logic, using the by keyword.

The "preferencesDataStore" delegate creates and manages a singleton DataStore<Preferences>
instance for the "user_prefs" file.

The delegate ensures lazy initialization, thread safety, and context-aware storage access.

Context is an Android class that provides access to app resources, file storage, and system services.
 */

//Extension property: Extending on Context
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")

class DataStoreActivity : AppCompatActivity() {

    private val KEY_NAME = stringPreferencesKey("user_name")
    private val KEY_DARK_MODE = booleanPreferencesKey("dark_mode")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_store)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        val etName = findViewById<EditText>(R.id.etName)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnShowData = findViewById<Button>(R.id.btnShowData)
        val tvDisplayName = findViewById<TextView>(R.id.tvDisplayName)
        val tvSavedThemeMode = findViewById<TextView>(R.id.tvSavedThemeMode)
        val cbDarkMode = findViewById<CheckBox>(R.id.cbDarkMode)

        // Load previously saved data
        lifecycleScope.launch {
            val savedName = dataStore.data.map {
                it[KEY_NAME] ?: "None"
            }.first()
            val isDarkMode = dataStore.data.map {
                it[KEY_DARK_MODE] ?: false
            }.first()

            etName.setText(savedName)
            cbDarkMode.isChecked = isDarkMode
        }

        // Save Data button click listener
        btnSave.setOnClickListener {
            //Launches a coroutine in the lifecycleScope of the Activity
            lifecycleScope.launch {

                //The code here inside the launch block runs asynchronously without
                //blocking the main (UI) thread

                //It is automatically canceled when the Activity is destroyed

                //edit function is a suspend function and edit operation is performed asynchronously

                //Suspend Function suspends the coroutine if the data isn’t immediately available,
                //allowing the main thread to process other tasks.

                dataStore.edit { prefs ->
                    prefs[KEY_NAME] = etName.text.toString()
                    prefs[KEY_DARK_MODE] = cbDarkMode.isChecked
                }
            }
        }

        // Show Data button click listener
        btnShowData.setOnClickListener {

            lifecycleScope.launch {
                val savedName = dataStore.data.map {
                    it[KEY_NAME] ?: "None"
                }.first()

                val isDarkMode = dataStore.data.map {
                    it[KEY_DARK_MODE] ?: false
                }.first()

                tvDisplayName.visibility = View.VISIBLE
                tvSavedThemeMode.visibility = View.VISIBLE

                tvDisplayName.text = "Saved Name: $savedName"
                tvSavedThemeMode.text = "Saved Mode: ${if (isDarkMode) "Dark" else "Light"}"
            }
        }
    }
}