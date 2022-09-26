package com.example.animex.presenter.home

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<out V: ViewBinding, in I>(
    val binding: V
): RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: I)
}