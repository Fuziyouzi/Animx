package com.example.animex.presenter.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.animex.R
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.core.observeEvent
import com.example.animex.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLogin : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {
    private val vm: ViewModelLogin by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpScreen.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentSignUp)
        }
        binding.signInLogin.setOnClickListener {
            login()
        }
        event()
        toast()
        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentForgotPassword)
        }
    }

    private fun login() {
        vm.login(
            email = binding.email.text.toString(),
            password = binding.password.text.toString()
        )
    }

    private fun toast() {
        vm.toast.observeEvent(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

    }

    private fun event() {
        vm.event.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentTabs)
        }
    }

}


