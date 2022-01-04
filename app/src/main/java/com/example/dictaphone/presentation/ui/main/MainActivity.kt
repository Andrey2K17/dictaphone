package com.example.dictaphone.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dictaphone.R
import com.example.dictaphone.presentation.ui.listOfRecords.ListOfRecordsFragment
import com.example.dictaphone.presentation.ui.other.OtherFragment
import com.example.dictaphone.presentation.ui.record.RecordFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recordFragment = RecordFragment()

        setFragment(recordFragment)

        bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_rec_item -> {
                    setFragment(recordFragment)
                }
                R.id.list_of_rec_item -> {
                    setFragment(ListOfRecordsFragment())
                }
                R.id.other_item -> {
                    setFragment(OtherFragment())
                }
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_container, fragment)
            commit()
        }
}