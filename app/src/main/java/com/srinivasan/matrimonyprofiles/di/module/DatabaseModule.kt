package com.srinivasan.matrimonyprofiles.di.module

import android.content.Context
import androidx.room.Room
import com.srinivasan.matrimonyprofiles.data.local.room.dao.ProfilesDao
import com.srinivasan.matrimonyprofiles.data.local.room.db.MatrimonyDatabase
import com.srinivasan.matrimonyprofiles.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27.April.2024:19:14

///////////////////////////////////////////////////////////////////////////////////////////////

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideMatrimonyDatabase(
        @ApplicationContext context: Context
    ): MatrimonyDatabase {

        return Room.databaseBuilder(
            context,
            MatrimonyDatabase::class.java,
            DATABASE_NAME
        ).build()

    }

    @Singleton
    @Provides
    fun provideProfilesDao(
        matrimonyDatabase: MatrimonyDatabase
    ): ProfilesDao {

        return matrimonyDatabase.profileDao()

    }

}