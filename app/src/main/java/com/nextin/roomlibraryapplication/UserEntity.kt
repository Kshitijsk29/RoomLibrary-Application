package com.nextin.roomlibraryapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey (autoGenerate = true) val id :Int,
    @ColumnInfo(name ="first_name") val name :String?,
    @ColumnInfo(name ="last_name") val surname :String,
    @ColumnInfo(name = "Date") val date: Date
)
