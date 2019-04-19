package com.beeete2.android.epoxyexample.ui.friend.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import com.beeete2.android.epoxyexample.model.entity.Friend
import com.beeete2.android.epoxyexample.model.repository.FriendRepository

class FriendListViewModel(
    private val friendRepository: FriendRepository
) : ViewModel() {

    private val tag by lazy { javaClass.simpleName }

    private val _friends = MutableLiveData<List<Friend>>()
    val friends = _friends.distinctUntilChanged()

    init {
        fetch()
    }

    private fun fetch() {
        _friends.value = friendRepository.fetchFriends()
    }

}
