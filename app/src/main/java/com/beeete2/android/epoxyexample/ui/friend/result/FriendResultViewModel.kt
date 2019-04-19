package com.beeete2.android.epoxyexample.ui.friend.result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import com.beeete2.android.epoxyexample.model.entity.Friend
import com.beeete2.android.epoxyexample.ui.friend.input.FriendHolder

class FriendResultViewModel constructor(
    private val holder: FriendHolder
) : ViewModel() {

    private val tag by lazy { javaClass.simpleName }

    private val _friend = MutableLiveData<Friend>()
    val friend = _friend.distinctUntilChanged()

    init {
        _friend.value = holder.getOrNull()
    }

}
