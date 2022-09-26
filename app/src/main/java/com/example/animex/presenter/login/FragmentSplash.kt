package com.example.animex.presenter.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.animex.R
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.databinding.FragmentSplashBinding

class FragmentSplash: BaseFragment<FragmentSplashBinding>(
    FragmentSplashBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getStarted.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSplash_to_fragmentLogin)
        }
    }


}