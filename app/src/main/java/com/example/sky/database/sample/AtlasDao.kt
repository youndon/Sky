package com.example.sky.database.sample

import androidx.room.*

@Dao
interface AtlasDao {

    @Query("SELECT * FROM userTable")
    fun readUser(): List<AtlasEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: AtlasEntity)

    @Delete
    fun deleteUser(user: AtlasEntity)

    @Update(entity = AtlasEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun editUser(user: AtlasEntity)
}