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
package com.plantix.plantixmocktest.data.repository

import com.plantix.plantixmocktest.data.db.AppDatabase
import com.plantix.plantixmocktest.data.db.entities.Name
import com.plantix.plantixmocktest.data.network.ApiManager
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiManager: ApiManager,
    private val db: AppDatabase
) : BaseRepository() {
    suspend fun getRemoteNames() = safeApiCall { apiManager.getNames() }

    fun getLocalNames() = db.getNameDao().getNames()

    suspend fun saveNames(names: List<Name>) = db.getNameDao().insertNames(names)
}
