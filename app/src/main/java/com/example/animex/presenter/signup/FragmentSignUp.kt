package com.example.animex.presenter.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.animex.R
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.core.observeEvent
import com.example.animex.databinding.FragmentSignUpBinding
import com.example.animex.domain.models.UserSignUp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSignUp : BaseFragment<FragmentSignUpBinding>(
    FragmentSignUpBinding::inflate
) {

    private val vm: ViewModelSignUp by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUp.setOnClickListener {
            createAccountButton()
            }
        vm.observe().observeEvent(viewLifecycleOwner){
            snackBar(it)
        }
        event()

        binding.loginScreen.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun createAccountButton() {
        val signUpModel = UserSignUp(
            email = binding.inputEmail.text.toString(),
            nickname = binding.inputNickname.text.toString(),
            password = binding.inputPassword.text.toString(),
            repeatPassword = binding.repeatPassword.text.toString()
        )
        vm.signUp(signUpModel)

    }

    private fun event(){
        vm.event.observeEvent(viewLifecycleOwner){
            findNavController().navigate(R.id.action_fragmentSignUp_to_fragmentInterests)
        }
    }
}