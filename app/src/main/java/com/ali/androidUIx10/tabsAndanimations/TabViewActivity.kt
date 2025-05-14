package com.ali.androidUIx10.tabsAndanimations

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.androidUIx10.R
import com.ali.androidUIx10.databinding.ActivityTabViewBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_tab_view)
        // Inflate the layout using View Binding and set it as the content view
        binding = ActivityTabViewBinding.inflate(layoutInflater)
        setContentView(binding.root) // Set the root view of the binding as the activity's content view

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up adapter for ViewPager2
        binding.viewPager.adapter =
            ViewPagerAdapter(this) // Initializes and assigns a custom ViewPagerAdapter to the ViewPager2, passing the current context (e.g., Activity or Fragment) to manage the fragments or views displayed within the ViewPager2.

        // Connect TabLayout and ViewPager2
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position -> // Creates a TabLayoutMediator to synchronize the TabLayout with the ViewPager2
            tab.text =
                when (position) { // Sets the text for each tab based on its position in the ViewPager2 using a when expression for concise conditional logic.
                    0 -> "Home" // Assigns the label "Home" to the first tab (position 0).
                    else -> "Profile" // Assigns the label "Profile" to any other tab (e.g., position 1 or higher).
                }
        }.attach() // Finalizes the TabLayoutMediator setup by linking the TabLayout and ViewPager2
    }
}