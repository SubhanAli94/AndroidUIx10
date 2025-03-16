package com.ali.androidUIx10.navigations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ali.androidUIx10.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MyBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closeButton: Button = view.findViewById(R.id.close_bottom_sheet)
        closeButton.setOnClickListener {
            dismiss()  // Close the bottom sheet
        }
    }
}