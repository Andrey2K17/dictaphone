package com.example.dictaphone

import android.app.Application
import androidx.room.Room
import com.example.dictaphone.db.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "audioRecords"
        ).build()
    }

    companion object {
        lateinit var instance: App
        lateinit var database: AppDatabase
    }
}