/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
