package com.example.animex.presenter.profile.logout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.navOptions
import com.example.animex.R
import com.example.animex.databinding.FragmentLogoutBinding
import com.example.animex.presenter.navigator.findTopNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLogout: BottomSheetDialogFragment() {

    private lateinit var binding: FragmentLogoutBinding

    private val vm: ViewModelLogout by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogoutBinding.inflate(layoutInflater, container,false)

        binding.cancelBtn.setOnClickListener {
            dialog?.dismiss()
        }
        binding.yesBtn.setOnClickListener {
           vm.logout()
            findTopNavController().navigate(R.id.fragmentSplash, null, navOptions{
                popUpTo(R.id.fragmentTabs){
                    inclusive = true
                }
            })

        }

        return binding.root
    }

}