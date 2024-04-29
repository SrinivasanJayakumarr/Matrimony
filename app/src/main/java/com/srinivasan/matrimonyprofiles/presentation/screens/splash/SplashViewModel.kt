package com.srinivasan.matrimonyprofiles.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srinivasan.matrimonyprofiles.data.repository.ProfilesRepository
import com.srinivasan.matrimonyprofiles.util.DummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 18:39

///////////////////////////////////////////////////////////////////////////////////////////////

@HiltViewModel
class SplashViewModel @Inject constructor (
    private val profilesRepository: ProfilesRepository,
    @Named("ioDispatcher") private val ioDispatcher: CoroutineDispatcher
): ViewModel() {

    fun initDatabase() {
        viewModelScope.launch(ioDispatcher) {

            val insertIds = profilesRepository.insertRecord(DummyData.profiles)
            println("Data inserted --> $insertIds")

        }
    }

}