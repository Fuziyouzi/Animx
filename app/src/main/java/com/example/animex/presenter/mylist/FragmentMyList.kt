package com.example.animex.presenter.mylist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.databinding.FragmentMylistBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentMyList: BaseFragment<FragmentMylistBinding>(
    FragmentMylistBinding::inflate
) {

    private val vm: ViewModelMyList by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}