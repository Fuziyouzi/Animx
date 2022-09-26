package com.example.animex.presenter.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.animex.presenter.navigator.findTopNavController
import com.google.android.material.snackbar.Snackbar


abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(inflater, container, false)


        return binding.root
    }

    protected fun launch(@IdRes id: Int) {
        findNavController().navigate(id)
    }

    protected fun launchOnTop(@IdRes id: Int) {
        findTopNavController().navigate(id)
    }

    protected fun back() {
        findNavController().popBackStack()
    }

    protected fun snackBar(text: String) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}