package com.example.dictaphone.presentation.ui.listOfRecords


import android.view.View
import android.view.ViewGroup
import com.example.dictaphone.R
import com.example.dictaphone.common.inflate
import com.example.dictaphone.domain.entity.OnRecordClick
import com.example.dictaphone.domain.entity.Record
import com.example.dictaphone.presentation.ui.base.BaseAdapter
import com.example.dictaphone.presentation.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.record_item.view.*

class ListOfRecordAdapter : BaseAdapter<Record>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Record> =
        parent.inflate(R.layout.record_item).let(::ViewHolder)

    private var callback: OnRecordClick? = null

    fun attachCallback(callback: OnRecordClick) {
        this.callback = callback
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder<Record>(itemView) {
        override fun bind(model: Record) {
            with(itemView) {
                this.setOnClickListener {
                    callback?.clickRecord(model.name)
                }
                tvRecordDuration.text = model.duration
                tvRecordName.text = model.name
            }
        }

    }
}