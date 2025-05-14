package com.ali.androidUIx10.tabsAndanimations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.TextView
import com.ali.androidUIx10.R
import com.google.android.material.transition.MaterialFadeThrough

class TabFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the fragment layout
        val view = inflater.inflate(R.layout.fragment_tab1, container, false)

        // Find the button using findViewById
        val animateButton = view.findViewById<Button>(R.id.animateButton)

        // Set click listener for animation
        animateButton.setOnClickListener { // Assigns a click listener to the animateButton to handle click events
            // Create scale animations for X and Y axes
            val scaleX = ObjectAnimator.ofFloat(animateButton, "scaleX", 1f, 1.5f, 1f) // Creates an animation to scale the button's X-axis from 100% to 150% and back to 100%
            val scaleY = ObjectAnimator.ofFloat(animateButton, "scaleY", 1f, 1.5f, 1f) // Creates an animation to scale the button's Y-axis from 100% to 150% and back to 100%

            // Create alpha animation for fade effect
            val alpha = ObjectAnimator.ofFloat(animateButton, "alpha", 1f, 0.2f, 1f) // Creates an animation to change the button's opacity from 100% to 50% and back to 100%

            // Combine animations using AnimatorSet
            val animatorSet = AnimatorSet() // Initializes an AnimatorSet to manage multiple animations
            animatorSet.playTogether(scaleX, scaleY, alpha) // Configures the AnimatorSet to play scaleX, scaleY, and alpha animations simultaneously
            animatorSet.duration = 1000 // Sets the duration of all animations to 500 milliseconds
            animatorSet.start() // Starts the combined animations
        }

        return view
    }
}