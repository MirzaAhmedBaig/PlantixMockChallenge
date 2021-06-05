package com.plantix.plantixmocktest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.plantix.plantixmocktest.data.db.dao.NameDao
import com.plantix.plantixmocktest.data.db.entities.Name

@Database(
    entities = [Name::class],
    version = DBConstants.DB_VERSION
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNameDao(): NameDao
}