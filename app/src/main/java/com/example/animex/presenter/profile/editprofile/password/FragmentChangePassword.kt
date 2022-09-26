package com.example.animex.presenter.profile.editprofile.password

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.core.observeEvent
import com.example.animex.databinding.FragmentChangePasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentChangePassword : BaseFragment<FragmentChangePasswordBinding>(
    FragmentChangePasswordBinding::inflate
) {

    private val vm: ViewModelPassword by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.observe().observeEvent(viewLifecycleOwner) {
            snackBar(it)
        }

        binding.confirmButton.setOnClickListener {
            vm.password(
                binding.passwordChange.text.toString(),
                binding.repeatPasswordChange.text.toString()
            )
        }
    }

}