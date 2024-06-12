package com.nextin.roomlibraryapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey (autoGenerate = true) val id :Int,
    @ColumnInfo(name ="roll no") val rollno :Int,
    @ColumnInfo(name ="name") val name :String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "stream") val stream: String,
)
