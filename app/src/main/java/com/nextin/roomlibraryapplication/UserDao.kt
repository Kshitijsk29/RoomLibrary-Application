package com.nextin.roomlibraryapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("select * from users ")
    fun getAllData() :LiveData<List<UserEntity>>

    @Insert
    suspend fun insertAll(vararg user : UserEntity)

    @Delete
    suspend fun deleteAll( user:UserEntity)

}