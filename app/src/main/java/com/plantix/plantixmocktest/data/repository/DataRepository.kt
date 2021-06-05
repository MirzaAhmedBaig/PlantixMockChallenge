package com.plantix.plantixmocktest.data.repository

import com.plantix.plantixmocktest.data.db.AppDatabase
import com.plantix.plantixmocktest.data.db.entities.Name
import com.plantix.plantixmocktest.data.network.ApiManager
import com.plantix.plantixmocktest.data.repository.BaseRepository
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiManager: ApiManager,
    private val db: AppDatabase
) : BaseRepository() {
    suspend fun getRemoteNames() = safeApiCall { apiManager.getNames() }

    fun getLocalNames() = db.getNameDao().getNames()

    suspend fun saveNames(names: List<Name>) = db.getNameDao().insertNames(names)
}
