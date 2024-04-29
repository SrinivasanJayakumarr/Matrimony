package com.srinivasan.matrimonyprofiles.data.repository

import com.srinivasan.matrimonyprofiles.data.local.room.dao.ProfilesDao
import com.srinivasan.matrimonyprofiles.data.local.room.entity.Profile
import javax.inject.Inject


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 18:59

///////////////////////////////////////////////////////////////////////////////////////////////

class ProfilesRepository @Inject constructor(
    private val profilesDao: ProfilesDao
) {

    suspend fun insertRecord(profiles: List<Profile>): List<Long> {

        // Delete dummy profiles
        if (profilesDao.getProfilesCount() > 0) {
            profilesDao.resetPrimaryKeyAutoIncrementValue()
            profilesDao.deleteAllProfiles()
        }

        return profilesDao.saveProfiles(profiles = profiles)
    }

    suspend fun getProfiles(): List<Profile> = profilesDao.getProfiles()

    suspend fun getProfileById(profileId: Int): Profile = profilesDao.getProfileById(profileId = profileId)

}