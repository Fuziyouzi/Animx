package com.example.animex.presenter.signup

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.animex.R
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.databinding.FragmentInterestsBinding


class FragmentInterests: BaseFragment<FragmentInterestsBinding>(
    FragmentInterestsBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.continueBtn.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentInterests_to_fragmentTabs)
        }
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}