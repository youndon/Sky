package com.example.sky.db.sample

import androidx.room.*

@Dao
interface AtlasDao {

    @Query("SELECT * FROM userTable")
    fun readUser(): List<AtlasEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: AtlasEntity)

    @Delete
    fun deleteUser(user: AtlasEntity)

    @Update
    fun editUser(user: AtlasEntity)
}