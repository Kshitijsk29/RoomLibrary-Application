package com.nextin.roomlibraryapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.nextin.roomlibraryapplication.data.AppDatabase
import com.nextin.roomlibraryapplication.data.UserEntity
import com.nextin.roomlibraryapplication.data.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyViewModel(application: Application):AndroidViewModel(application)
{
    private val readAllData : LiveData<List<UserEntity>>
    private val repository : UserRepository

    init {
        val database = AppDatabase.getDatabase(application).userDao()
            repository= UserRepository(database)
            readAllData = repository.readAllData
    }

    fun addUser(user : UserEntity){
        GlobalScope.launch{
            repository.addUser(user)
        }
    }

}