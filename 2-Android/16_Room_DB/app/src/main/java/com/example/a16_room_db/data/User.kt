package com.example.a16_room_db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// 1
@Entity(tableName = "users_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val lastName: String,
    val age: Int
)