package com.example.animex.presenter.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animex.R
import com.example.animex.core.observeEvent
import com.example.animex.databinding.FragmentHomeBinding
import com.example.animex.presenter.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome: BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    private val vm: ViewModelHome by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.seeAllTopHits.setOnClickListener {
            launchOnTop(R.id.action_fragmentTabs_to_fragmentTopHitsAnime)
        }

        binding.seeAllNewReleases.setOnClickListener {
            launchOnTop(R.id.action_fragmentTabs_to_fragmentNewEpisodesRelease)
        }

        binding.notificationImage.setOnClickListener {
            launchOnTop(R.id.action_fragmentTabs_to_fragmentNotifications)
        }
        binding.seeTop100All.setOnClickListener {
            launchOnTop(R.id.action_fragmentTabs_to_fragmentTop100Anime)
        }

        binding.playButton.setOnClickListener {
            launchOnTop(R.id.action_fragmentTabs_to_fragmentAnime)
        }
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.topHitsList.layoutManager = layout
        val adapter = AnimeAdapter(Anam.lsit1)
        binding.topHitsList.adapter = adapter

        vm.anime.observeEvent(viewLifecycleOwner){
        }
        vm.observe().observeEvent(viewLifecycleOwner){
            snackBar(it)
        }

    }

}