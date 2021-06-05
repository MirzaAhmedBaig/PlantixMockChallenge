package com.plantix.plantixmocktest.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Name(
    @PrimaryKey
    val id: Int,
    val firstName: String,
    val lastName: String
)