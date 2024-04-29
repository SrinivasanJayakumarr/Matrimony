package com.srinivasan.matrimonyprofiles.data.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.srinivasan.matrimonyprofiles.data.local.room.dao.ProfilesDao
import com.srinivasan.matrimonyprofiles.data.local.room.entity.Profile
import com.srinivasan.matrimonyprofiles.util.Constants.DATABASE_VERSION


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 19:02

///////////////////////////////////////////////////////////////////////////////////////////////

@Database(
    entities = [Profile::class],
    version = DATABASE_VERSION,
    exportSchema = true
)
abstract class MatrimonyDatabase: RoomDatabase() {

    abstract fun profileDao(): ProfilesDao

}