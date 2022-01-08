package com.example.dictaphone.presentation.ui.listOfRecords

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictaphone.App
import com.example.dictaphone.R
import com.example.dictaphone.db.AppDatabase
import com.example.dictaphone.db.AudioRecord
import com.example.dictaphone.domain.entity.OnRecordClick
import kotlinx.android.synthetic.main.fragment_list_of_records.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListOfRecordsFragment : Fragment(R.layout.fragment_list_of_records) {
    private val listOfRecordAdapter = ListOfRecordAdapter()
    private lateinit var records: ArrayList<AudioRecord>
    private lateinit var db: AppDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listOfRecordAdapter.attachCallback(object : OnRecordClick {
            override fun clickRecord(name: String) {
                Toast.makeText(activity, "Вы нажали на $name", Toast.LENGTH_SHORT).show()
            }

        })

        records = ArrayList()
        db = App.database

//            listOfRecordAdapter.mDataList = records

        rvRecordList.layoutManager = LinearLayoutManager(activity)
        rvRecordList.adapter = listOfRecordAdapter
        fetchRecords()
            listOfRecordAdapter.mDataList = records
    }

    private fun fetchRecords() {
        GlobalScope.launch {
            Log.d("test123", "aaaaaaaaaaaaaa")
            records.clear()
            var queryResult = db.audioRecordDao().getAll()
            Log.d("test123", queryResult.toString())
            records.addAll(queryResult)
        }
    }
}