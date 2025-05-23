package com.ali.androidUIx10.navigations.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.ali.androidUIx10.R

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        view.findViewById<Button>(R.id.buttonBack).setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_homeFragment)
        }
        return view
    }
}