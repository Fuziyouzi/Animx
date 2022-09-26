package com.example.animex.presenter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.animex.databinding.TopHitsAnimeHomeBinding

class AnimeAdapter(val anime: List<Datas>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {


   inner class AnimeViewHolder(binding: TopHitsAnimeHomeBinding) :
        BaseViewHolder<TopHitsAnimeHomeBinding, Datas>(binding) {
        override fun bind(item: Datas) {
            with(binding) {
                rating.text = item.rate.toString()
            }
        }


    }

    override fun getItemCount(): Int = anime.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopHitsAnimeHomeBinding.inflate(inflater, parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(anime[position])
        val positionAn = position + 1
           holder.binding.topPlace.text = positionAn.toString()
    }

    fun update(){
       val difCallback = AnimeDiffUtil(emptyList(), listOf())
        val diffCalculate = DiffUtil.calculateDiff(difCallback)
        diffCalculate.dispatchUpdatesTo(this)
    }
    /**
     * We create a diff class give to him a old and new list
     * we set our listeners and when we change something we need to get to fun method list
     * and diffutils update all
     */
}
class AnimeDiffUtil(
    private val oldList: List<Datas>,
    private val newList: List<Datas>
): DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }


}