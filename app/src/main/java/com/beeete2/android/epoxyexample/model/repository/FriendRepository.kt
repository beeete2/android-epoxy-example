package com.beeete2.android.epoxyexample.model.repository

import com.beeete2.android.epoxyexample.model.entity.Friend

interface FriendRepository {

    fun fetchFriends(): List<Friend>

}
