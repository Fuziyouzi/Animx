package com.example.animex.presenter.profile.helpcenter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.databinding.FragmentHelpCenterBinding
import com.google.android.material.tabs.TabLayoutMediator

class FragmentHelpCenter: BaseFragment<FragmentHelpCenterBinding>(
    FragmentHelpCenterBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf<Fragment>(
            FragmentFaq(),
            FragmentContactUs()
        )
        val adapter = FragmentPagerAdapterHelpCenter(
            list,
            parentFragmentManager,
            lifecycle
        )
        binding.viewPagerHelpCenter.adapter = adapter
       TabLayoutMediator(binding.tabLayout, binding.viewPagerHelpCenter){tab, pos->
           when(pos){
               0 -> {tab.text = "FAQ"}
               1 -> {tab.text = "Contact Us"}
           }
       }.attach()
    }
}