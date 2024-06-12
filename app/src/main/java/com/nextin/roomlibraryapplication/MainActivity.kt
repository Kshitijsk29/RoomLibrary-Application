package com.nextin.roomlibraryapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.nextin.roomlibraryapplication.databinding.ActivityMainBinding

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // initializing database

        database = AppDatabase.getDatabase(this)

     // calling suspend function
        binding.btnClick.setOnClickListener{
            GlobalScope.launch{
                database.userDao().insertAll(UserEntity(0,
                    Integer.parseInt(binding.etRollNo.text.toString()),
                    binding.etStudent.text.toString(),
                    binding.etAdress.text.toString(),
                    binding.etStream.text.toString()))
        }
            Toast.makeText(this, "Successful",
                Toast.LENGTH_LONG).show()
        }
    }
    // retriving data of database using observer of live data
    fun getData(view: View) {
        database.userDao().getAllData().observe(this, Observer {
            Log.i("heyy user",it.toString())
        })
    }
}