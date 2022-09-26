package com.example.animex.presenter.profile.helpcenter

import android.os.Bundle
import android.view.View
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.databinding.FragmentFaqBinding

class FragmentFaq: BaseFragment<FragmentFaqBinding>(
    FragmentFaqBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.whatIs.setOnClickListener {
            if (binding.line1.visibility == View.GONE){
                binding.line1.visibility = View.VISIBLE
                binding.text1.visibility = View.VISIBLE
            }else{
                binding.line1.visibility = View.GONE
                binding.text1.visibility = View.GONE
            }
        }
    }
}