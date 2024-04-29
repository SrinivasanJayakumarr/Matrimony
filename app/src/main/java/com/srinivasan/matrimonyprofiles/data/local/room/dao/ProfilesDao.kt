package com.srinivasan.matrimonyprofiles.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.srinivasan.matrimonyprofiles.data.local.room.entity.Profile


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 19:02

///////////////////////////////////////////////////////////////////////////////////////////////

@Dao
interface ProfilesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveProfiles(profiles: List<Profile>): List<Long>

    @Query("SELECT * FROM Profile")
    suspend fun getProfiles(): List<Profile>

    @Query("SELECT COUNT(*) FROM Profile")
    suspend fun getProfilesCount(): Int

    @Query("DELETE FROM Profile")
    suspend fun deleteAllProfiles()

    @Query("SELECT * FROM Profile WHERE id LIKE :profileId")
    suspend fun getProfileById(profileId: Int): Profile

    @Query("UPDATE SQLITE_SEQUENCE SET seq = 0 WHERE name = \'Profile\'")
    fun resetPrimaryKeyAutoIncrementValue()

}