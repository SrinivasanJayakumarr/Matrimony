package com.srinivasan.matrimonyprofiles.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srinivasan.matrimonyprofiles.data.local.room.entity.Profile
import com.srinivasan.matrimonyprofiles.data.repository.ProfilesRepository
import com.srinivasan.matrimonyprofiles.util.DummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 18:40

///////////////////////////////////////////////////////////////////////////////////////////////

@HiltViewModel
class HomeViewModel @Inject constructor (
    private val profilesRepository: ProfilesRepository,
    @Named("ioDispatcher") private val ioDispatcher: CoroutineDispatcher,
): ViewModel() {

    private val _profiles: MutableStateFlow<List<Profile>> = MutableStateFlow(emptyList())
    val profiles = _profiles.asStateFlow()

    init {

        viewModelScope.launch(ioDispatcher) {
            val profilesFromDb = profilesRepository.getProfiles().toMutableList()
            profilesFromDb.forEachIndexed { index, profile ->
                profile.apply {
                    image = DummyData.profileImages[index]
                    qualifiers = DummyData.qualifiers[index]
                }
            }
            _profiles.emit(profilesFromDb)
        }

    }

    fun deleteProfile(
        index: Int
    ) {
        viewModelScope.launch(ioDispatcher) {
            val updatedProfiles = _profiles.value.toMutableList()
                .also {
                    it.removeAt(index)
                }
            _profiles.emit(updatedProfiles)
        }
    }

}