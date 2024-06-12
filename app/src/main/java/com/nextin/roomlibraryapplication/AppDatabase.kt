package com.nextin.roomlibraryapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.migration.Migration


@Database(entities =[UserEntity::class], version = 2)
@TypeConverters(Convetors::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun  userDao():UserDao

    companion object{

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase{

            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "contactDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}