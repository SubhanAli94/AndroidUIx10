package com.ali.androidUIx10.tabsAndanimations

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : // Takes a FragmentActivity as a constructor parameter to provide the context for fragment management
    FragmentStateAdapter(fragmentActivity) { // Extends FragmentStateAdapter, a ViewPager2 adapter class that handles fragment lifecycle and state efficiently

    // List of fragments to display in ViewPager2
    private val fragments = listOf(TabFragment1(), TabFragment2())

    // Return the total number of fragments
    override fun getItemCount(): Int = fragments.size

    // Return the fragment at the specified position
    override fun createFragment(position: Int): Fragment = fragments[position]
}
