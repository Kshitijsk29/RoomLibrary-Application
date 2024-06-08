package com.nextin.roomlibraryapplication

import androidx.room.TypeConverter
import java.util.Date


class Convetors {

    @TypeConverter
    fun fromDateToLong (value: Date):Long{
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value :Long):Date{
        return Date(value)
    }

}