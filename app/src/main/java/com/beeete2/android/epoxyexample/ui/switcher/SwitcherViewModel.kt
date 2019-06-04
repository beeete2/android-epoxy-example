package com.beeete2.android.epoxyexample.ui.switcher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beeete2.android.epoxyexample.model.entity.Friend

class SwitcherViewModel : ViewModel() {

    private val _friend = MutableLiveData<Friend>()
    val friend: LiveData<Friend> = _friend

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String> = _toast

    init {
        _friend.value = Friend(id = -1)
    }

    fun setBlock(value: Boolean) {
        _toast.value = "Can not be changed."
        _friend.value = _friend.value?.copy()
    }

    fun setFavorite(value: Boolean) {
        _toast.value = "Can not be changed."
        _friend.value = _friend.value?.copy()
    }

}
