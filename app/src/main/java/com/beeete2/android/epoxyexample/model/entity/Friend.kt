package com.beeete2.android.epoxyexample.model.entity

data class Friend(
    val id: Long,
    val firstName: String = "",
    val phoneticFirstName: String = "",
    val lastName: String = "",
    val phoneticLastName: String = "",
    val gender: Gender = Gender.UNANSWERED,
    val address: String = "",
    val notes: String = "",
    val block: Boolean = false,
    val favorite: Boolean = false
)

enum class Gender {
    MALE,
    FEMALE,
    UNKNOWN,
    UNANSWERED
}
