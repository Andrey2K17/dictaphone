package com.example.dictaphone.presentation.ui.listOfRecords


import android.view.View
import android.view.ViewGroup
import com.example.dictaphone.R
import com.example.dictaphone.common.inflate
import com.example.dictaphone.db.AudioRecord
import com.example.dictaphone.domain.entity.OnRecordClick
import com.example.dictaphone.presentation.ui.base.BaseAdapter
import com.example.dictaphone.presentation.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.record_item.view.*

class ListOfRecordAdapter : BaseAdapter<AudioRecord>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<AudioRecord> =
        parent.inflate(R.layout.record_item).let(::ViewHolder)

    private var callback: OnRecordClick? = null

    fun attachCallback(callback: OnRecordClick) {
        this.callback = callback
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder<AudioRecord>(itemView) {
        override fun bind(model: AudioRecord) {
            with(itemView) {
                this.setOnClickListener {
                    callback?.clickRecord(model.fileName)
                }
                tvFileName.text = model.fileName
                tvMeta.text = model.duration
            }
        }

    }
}