package com.beeete2.android.epoxyexample.ui.friend.input

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import com.beeete2.android.epoxyexample.model.entity.Friend
import com.beeete2.android.epoxyexample.model.entity.Gender

class FriendInputViewModel constructor(
    private val holder: FriendHolder
) : ViewModel() {

    private val tag by lazy { javaClass.simpleName }

    private val _friend = MutableLiveData<Friend>()
    val friend = _friend.distinctUntilChanged()

    init {
        _friend.value = holder.getOrNull() ?: Friend(
            id = -1,
            firstName = "",
            phoneticFirstName = "",
            lastName = "",
            phoneticLastName = "",
            gender = Gender.UNANSWERED,
            address = "",
            block = false,
            favorite = false,
            notes = ""
        )
    }

    fun setFirstName(text: String) {
        _friend.value = _friend.value?.copy(firstName = text)
    }

    fun setLastName(text: String) {
        _friend.value = _friend.value?.copy(lastName = text)
    }

    fun setPhoneticFirstName(text: String) {
        _friend.value = _friend.value?.copy(phoneticFirstName = text)
    }

    fun setPhoneticLastName(text: String) {
        _friend.value = _friend.value?.copy(phoneticLastName = text)
    }

    fun setGenderMale() {
        _friend.value = _friend.value?.copy(gender = Gender.MALE)
    }

    fun setGenderFemale() {
        _friend.value = _friend.value?.copy(gender = Gender.FEMALE)
    }

    fun setGenderUnknown() {
        _friend.value = _friend.value?.copy(gender = Gender.UNKNOWN)
    }

    fun setAddress(text: String) {
        _friend.value = _friend.value?.copy(address = text)
    }

    fun setBlock(isChecked: Boolean) {
        _friend.value = _friend.value?.copy(block = isChecked)
    }

    fun setFavorite(isChecked: Boolean) {
        _friend.value = _friend.value?.copy(favorite = isChecked)
    }

    fun setNotes(text: String) {
        _friend.value = _friend.value?.copy(notes = text)
    }

    fun done() {
        _friend.value?.let {
            holder.hold(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
        holder.release()
    }
}
