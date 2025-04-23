package com.ali.androidUIx10

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*
        Multithreading means doing many tasks at the same time using multiple threads.

        A thread is like a worker in your app — it runs a set of instructions, step by step.
        It’s the smallest unit of execution used by the CPU to get work done.

        Your app tells the operating system: “I want to do this task in the background.”
            1. The OS creates a thread — a worker — and gives it time to run on the CPU.
            2. The CPU executes that thread’s instructions.
            3. If you have multiple threads, the CPU switches quickly between them to make it look
            like everything is running at the same time.

        8 threads on an 8-core CPU -> all can run truly in parallel
        100 threads on an 8-core CPU -> the OS will switch between them (timeslicing)

        1. UI thread -> handles the screen and user input
        2. Background threads -> handle downloads, file saving, etc
         */

        //lifecycleScope is a safe space to launch coroutines in an Activity or Fragment.
        lifecycleScope.launch {
            // Delay for 3 seconds
            delay(3000)

            // Navigate to main activity
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)

            // Close splash activity to prevent going back
            finish()
        }
    }
}