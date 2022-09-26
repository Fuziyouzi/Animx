package com.example.animex.presenter.profile.editprofile

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.animex.R
import com.example.animex.databinding.FragmentEditProfileBinding
import com.example.animex.presenter.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentEditProfile : BaseFragment<FragmentEditProfileBinding>(
    FragmentEditProfileBinding::inflate
) {

    private val vm: ViewModelEditProfile by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.editNickname.setOnClickListener {
            launch(R.id.action_fragmentEditProfile_to_fragmentNickname)
        }
        binding.editEmail.setOnClickListener {
            launch(R.id.action_fragmentEditProfile_to_fragmentEmail)
        }
        binding.editPassword.setOnClickListener {
            launch(R.id.action_fragmentEditProfile_to_fragmentChangePassword)
        }
        binding.avatarImage.setOnClickListener {
            checkPermission()
        }
        vm.imageEv.observe(viewLifecycleOwner) {
            binding.avatarImage.setImageBitmap(it.get())
        }

    }

    private val getImage =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            try {
                if (Build.VERSION.SDK_INT < 28) {
                    val bitmap = MediaStore.Images.Media.getBitmap(
                        requireContext().contentResolver,
                        uri
                    )
                    vm.changeImage(bitmap)
                } else {
                    val source = uri?.let {
                        ImageDecoder.createSource(
                            requireContext().contentResolver,
                            it
                        )
                    }
                    val bitmap = source?.let { ImageDecoder.decodeBitmap(it) }
                    vm.changeImage(bitmap)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    private val launchPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    )
    { isGranted: Boolean ->
        if (isGranted) {
            getImage.launch("image/*")

        } else {
            snackBar("Permission denied")
        }
    }

    private fun checkPermission() {
        when (ContextCompat.checkSelfPermission(
            requireContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE
        )) {
            PackageManager.PERMISSION_GRANTED -> getImage.launch("image/*")
            PackageManager.PERMISSION_DENIED -> showPermissionDialog()
            else -> launchPermissionRequest.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private fun showPermissionDialog() {
        val intent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", requireActivity().packageName, null)
        )
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.permission)
            .setMessage(R.string.messagePermission)
            .setPositiveButton(R.string.open) { _, _ ->
                startActivity(intent)
            }
            .setNegativeButton(R.string.Cancel) { dialog: DialogInterface, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}