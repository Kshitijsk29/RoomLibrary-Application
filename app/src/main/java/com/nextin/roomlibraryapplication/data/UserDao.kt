package com.nextin.roomlibraryapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.nextin.roomlibraryapplication.data.UserEntity

@Dao
interface UserDao {

    @Query("select * from users ")
    fun getAllData() :LiveData<List<UserEntity>>

    @Insert
    suspend fun insertAll(vararg user : UserEntity)

    @Update
    suspend fun updateAll(vararg user : UserEntity)

    @Delete
    suspend fun deleteAll( user: UserEntity)

}