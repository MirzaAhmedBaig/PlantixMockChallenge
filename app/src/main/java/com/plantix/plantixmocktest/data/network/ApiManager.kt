package com.plantix.plantixmocktest.data.network

import com.plantix.plantixmocktest.data.db.entities.Name
import retrofit2.http.GET

interface ApiManager {
    @GET(EndPoints.GET_COUPONS)
    suspend fun getNames(): List<Name>
}
