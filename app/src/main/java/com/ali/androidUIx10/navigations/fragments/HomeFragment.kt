package com.ali.androidUIx10.navigations.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.ali.androidUIx10.R


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.findViewById<Button>(R.id.buttonNavigate).setOnClickListener {
            //findNavController().navigate(R.id.action_homeFragment_to_secondFragment)

            /*
            ConfirmationDialog(onConfirm = { })
            .show(parentFragmentManager, "ConfirmationDialog")
             */

            /*
                // Show the Bottom Sheet
                val bottomSheet = MyBottomSheetFragment()
                bottomSheet.show(parentFragmentManager, "MyBottomSheet")
             */
        }
        return view
    }
}

class ConfirmationDialog(private val onConfirm: () -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Confirm Action")
            .setMessage("Are you sure?")
            .setPositiveButton("Yes", { _, _ -> onConfirm() })
            .setNegativeButton("No", null)
            .create()
    }
}