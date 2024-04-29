package com.srinivasan.matrimonyprofiles.util

import com.srinivasan.matrimonyprofiles.R
import com.srinivasan.matrimonyprofiles.data.local.room.entity.Profile
import com.srinivasan.matrimonyprofiles.data.local.room.entity.Qualifiers

object DummyData {

    val profiles = listOf(
        Profile(),
        Profile(
            name = "Profile #2",
            age = 26,
            height = 5.5F,
            education = "B.A",
            profession = "Teacher",
            horoscopeStar = "Punar Poosam",
            religionCaste = "Hindu",
            address = "Salem, TamilNadu"
        ),
        Profile(
            name = "Profile #3",
            age = 22,
            height = 5.0F,
            education = "B.Sc",
            profession = "Medical Coding",
            horoscopeStar = "Poorattathi",
            religionCaste = "Hindu",
            address = "Dindigul, TamilNadu"
        ),
        Profile(
            name = "Profile #4",
            age = 25,
            height = 6.5F,
            education = "B.Com",
            profession = "Lecturer",
            horoscopeStar = "Poosam",
            religionCaste = "Hindu",
            address = "Theni, TamilNadu"
        ),
        Profile(
            name = "Profile #5",
            age = 20,
            height = 6.0F,
            education = "B.B.A",
            profession = "HR",
            horoscopeStar = "Thiruvadhirai",
            religionCaste = "Hindu",
            address = "Madurai, TamilNadu"
        ),
    )

    val profileImages = listOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4,
        R.drawable.image_5,
    )

    val qualifiers = listOf(
        listOf(Qualifiers.VERIFIED, Qualifiers.PREMIUM_NRI),
        listOf(Qualifiers.PREMIUM_NRI),
        listOf(Qualifiers.VERIFIED),
        listOf(Qualifiers.VERIFIED),
        listOf(Qualifiers.PREMIUM_NRI),
    )

}