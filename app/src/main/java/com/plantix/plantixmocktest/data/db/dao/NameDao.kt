package com.plantix.plantixmocktest.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plantix.plantixmocktest.data.db.entities.Name

@Dao
interface NameDao {
    @Insert
    suspend fun insertName(name: Name)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNames(names: List<Name>)

    @Query("select * from Name")
    fun getNames(): LiveData<List<Name>>

}
