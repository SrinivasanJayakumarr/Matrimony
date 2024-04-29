package com.srinivasan.matrimonyprofiles.di.module

import com.srinivasan.matrimonyprofiles.data.local.room.dao.ProfilesDao
import com.srinivasan.matrimonyprofiles.data.repository.ProfilesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27.April.2024:19:20

///////////////////////////////////////////////////////////////////////////////////////////////

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideProfilesRepository(
        profilesDao: ProfilesDao
    ): ProfilesRepository {
        return ProfilesRepository(profilesDao = profilesDao)
    }

}