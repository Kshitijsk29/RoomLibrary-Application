package com.nextin.roomlibraryapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initializing database

        database = AppDatabase.getDatabase(this)

     // calling suspend function
        GlobalScope.launch{
            database.userDao().insertAll(UserEntity(0,
                "ram", "kapoor" , java.util.Date()
            ))
        }
    }
    // retriving data of database using observer of live data
    fun getData(view: View) {
        database.userDao().getAllData().observe(this, Observer {
            Log.i("heyy user",it.toString())
        })
    }
}