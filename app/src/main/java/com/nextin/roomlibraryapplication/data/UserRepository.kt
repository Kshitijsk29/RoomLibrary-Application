package com.nextin.roomlibraryapplication.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao : UserDao) {

    val readAllData :LiveData<List<UserEntity>> = userDao.getAllData()

    suspend  fun addUser( user :UserEntity){
        userDao.insertAll(user)
    }
}