package com.nextin.roomlibraryapplication

import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.room.InvalidationTracker
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initializing database
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "userDB"
        ).build()
     // calling suspend function
        GlobalScope.launch{
            database.userDao().insertAll(UserEntity(0, "ram", "kapoor"))
        }

    }

    // retriving data of database using observer of live data
    fun getData(view: View) {
        database.userDao().getAllData().observe(this, Observer {
            Log.i("heyy user",it.toString())
        })
    }
}