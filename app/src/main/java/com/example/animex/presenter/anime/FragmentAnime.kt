package com.example.animex.presenter.anime

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.animex.core.observeEvent
import com.example.animex.databinding.FragmentAnimeScreenBinding
import com.example.animex.presenter.base.BaseFragment
import com.example.animex.presenter.navigator.ImageLoader
import com.example.animex.presenter.navigator.ImageLoaderImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentAnime : BaseFragment<FragmentAnimeScreenBinding>(
    FragmentAnimeScreenBinding::inflate
) {

    private val vm: ViewModelAnime by viewModels()
    private val glide: ImageLoader = ImageLoaderImpl()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        get(view)

        vm.observe().observeEvent(viewLifecycleOwner) {
            snackBar(it)
        }

    }


    private fun get(view: View) {
        vm.anime.observeEvent(viewLifecycleOwner) {
            binding.included.animeName.text = it.data.canonicalTitle
            binding.included.text.text = it.data.synopsis
            binding.included.animeYear.text = it.data.endDate
            binding.included.badgePg.text = it.data.ageRating
            binding.included.rating.text = it.data.averageRating
            binding.included.episodesCount.text = it.data.episodeCount.toString()
            glide.showMainImage(view, it.data.coverImage, binding.imageAnime)
            binding.progressBar.visibility = View.GONE
            binding.included.layout.visibility = View.VISIBLE
            binding.appBar.visibility = View.VISIBLE
        }
    }


}