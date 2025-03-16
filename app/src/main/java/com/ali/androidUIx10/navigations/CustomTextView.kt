package com.ali.androidUIx10.navigations

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.ali.androidUIx10.R

class CustomTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    init {
        setTextColor(ContextCompat.getColor(context, R.color.yellow))
        textSize = 18f
        setPadding(16, 16, 16, 16)
    }
}