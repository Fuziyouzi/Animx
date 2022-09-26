package com.example.animex

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.animex.data.room.Converter
import com.example.animex.data.room.UserDao
import com.example.animex.data.room.UserEntity

@Database(
    version  = 2,
    entities = [
        UserEntity::class
    ]
)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

}