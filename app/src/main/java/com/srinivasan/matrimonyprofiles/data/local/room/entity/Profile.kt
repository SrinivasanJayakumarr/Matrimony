package com.srinivasan.matrimonyprofiles.data.local.room.entity

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.srinivasan.matrimonyprofiles.R

@Entity
data class Profile(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "Profile #1",
    var age: Int = 27,
    var height: Float = 5.5F,
    var education: String = "MBBS",
    var profession: String = "Doctor",
    var horoscopeStar: String = "Poosam",
    var religionCaste: String = "Hindu - Kayastha",
    var address: String = "Chennai, TamilNadu",
    @Ignore
    @DrawableRes var image: Int = R.drawable.image_1,
    @Ignore
    var qualifiers: List<Qualifiers> = listOf(Qualifiers.VERIFIED, Qualifiers.PREMIUM_NRI),
)

enum class Qualifiers(
    val value: String,
    @DrawableRes val icon: Int,
    val color: Color
) {
    VERIFIED(value = "Verified", icon = R.drawable.ic_verified, color = Color.Blue),
    PREMIUM_NRI(value = "Premium NRI", icon = R.drawable.ic_premium_nri, color = Color.DarkGray)
}
