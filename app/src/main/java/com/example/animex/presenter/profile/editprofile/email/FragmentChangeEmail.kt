package com.example.animex.presenter.profile.editprofile.email

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.core.observeEvent
import com.example.animex.databinding.FragmentChangeEmailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentChangeEmail : BaseFragment<FragmentChangeEmailBinding>(
    FragmentChangeEmailBinding::inflate
) {
    private val vm: ViewModelEmail by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.observe().observeEvent(viewLifecycleOwner){
            snackBar(it)
        }

        binding.confirmButton.setOnClickListener {
            vm.changeEmail(
                binding.emailChange.text.toString(),
                binding.emailChangeConfirm.text.toString()
            )
        }

    }


}