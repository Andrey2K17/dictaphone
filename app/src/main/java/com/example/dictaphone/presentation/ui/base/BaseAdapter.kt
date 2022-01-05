package com.example.dictaphone.presentation.ui.base

import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

abstract class BaseAdapter<P> : RecyclerView.Adapter<BaseViewHolder<P>>() {
    var mDataList: List<P> by Delegates.observable(listOf()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<P>, position: Int) {
        holder.bind(mDataList[position])
    }

    override fun getItemCount() = mDataList.size
}