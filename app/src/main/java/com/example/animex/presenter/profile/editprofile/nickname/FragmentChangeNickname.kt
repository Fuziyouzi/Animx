package com.example.animex.presenter.profile.editprofile.nickname

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.core.observeEvent
import com.example.animex.databinding.FragmentEditNicknameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentChangeNickname : BaseFragment<FragmentEditNicknameBinding>(
    FragmentEditNicknameBinding::inflate
) {

    private val vm: ViewModelNickname by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        vm.nick.observe(viewLifecycleOwner) {
            binding.nickName.setText(it)
        }
        binding.confirmButton.setOnClickListener {
            vm.updateNickname(binding.nickName.text.toString())
        }
        vm.observe().observeEvent(viewLifecycleOwner) {
            snackBar(it)
        }

    }

}