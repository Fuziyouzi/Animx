package com.example.animex.presenter

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.animex.R
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.databinding.FragmentTabsBinding

class FragmentTabs : BaseFragment<FragmentTabsBinding>(
    FragmentTabsBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = childFragmentManager.findFragmentById(R.id.tabsContainer) as NavHostFragment
        val navController = navHost.navController

        NavigationUI.setupWithNavController(binding.bottomNavView, navController)



    }
}