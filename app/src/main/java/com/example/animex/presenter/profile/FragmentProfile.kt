package com.example.animex.presenter.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.animex.R
import com.example.animex.databinding.FragmentProfileBinding
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.presenter.profile.logout.FragmentLogout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentProfile : BaseFragment<FragmentProfileBinding>(
    FragmentProfileBinding::inflate
) {
    private val vm: ViewModelProfile by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editProfile.setOnClickListener {
           launchOnTop(R.id.action_fragmentTabs_to_fragmentEditProfile)
        }
        binding.notification.setOnClickListener {
            launchOnTop(R.id.action_fragmentTabs_to_fragmentNotificationSettings)
        }
        binding.privacyPolicy.setOnClickListener {
           launchOnTop(R.id.action_fragmentTabs_to_fragmentPrivacyPolicy)
        }
        binding.helpCenter.setOnClickListener {
            launchOnTop(R.id.action_fragmentTabs_to_fragmentHelpCenter)
        }
        vm.user.observe(viewLifecycleOwner){
            binding.nickName.text = it?.nickname
            binding.email.text = it?.email
            binding.avatarImage.setImageBitmap(it?.image)
        }
        binding.logout.setOnClickListener {
            val dialog = FragmentLogout()
            dialog.show(parentFragmentManager, "FragmentLogout.TAG)")
        }

    }


}