package com.srinivasan.matrimonyprofiles.presentation.screens.profiledetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srinivasan.matrimonyprofiles.data.local.room.entity.Profile
import com.srinivasan.matrimonyprofiles.data.repository.ProfilesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 18:41

///////////////////////////////////////////////////////////////////////////////////////////////

@HiltViewModel
class ProfileDetailsViewModel @Inject constructor (
    private val profilesRepository: ProfilesRepository,
    @Named("ioDispatcher") private val ioDispatcher: CoroutineDispatcher,
): ViewModel() {

    private val _profile: MutableStateFlow<Profile> = MutableStateFlow(Profile())
    val profile = _profile.asStateFlow()

    fun getProfileById(profileId: Int) {
        viewModelScope.launch(ioDispatcher) {
            val profileFromDb = profilesRepository
                .getProfileById(profileId = profileId)
            _profile.emit(profileFromDb)
        }
    }

}