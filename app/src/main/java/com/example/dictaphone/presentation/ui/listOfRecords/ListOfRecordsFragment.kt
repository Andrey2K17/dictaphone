package com.example.dictaphone.presentation.ui.listOfRecords

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictaphone.R
import com.example.dictaphone.domain.entity.OnRecordClick
import com.example.dictaphone.domain.entity.Record
import kotlinx.android.synthetic.main.fragment_list_of_records.*

class ListOfRecordsFragment : Fragment(R.layout.fragment_list_of_records) {
    private val listOfRecordAdapter = ListOfRecordAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (listOfRecordAdapter.mDataList.isEmpty()) {
            val listOfRecord = listOf(
                Record(name = "Запись1", duration = "3:50"),
                Record(name = "Запись2", duration = "2:20")
            )
            listOfRecordAdapter.attachCallback(object : OnRecordClick {
                override fun clickRecord(name: String) {
                    Toast.makeText(activity, "Вы нажали на $name", Toast.LENGTH_SHORT).show()
                }

            })
            listOfRecordAdapter.mDataList = listOfRecord
        }

        rvRecordList.layoutManager = LinearLayoutManager(activity)
        rvRecordList.adapter = listOfRecordAdapter
    }
}