package com.beeete2.android.epoxyexample.ui.friend.input

import com.beeete2.android.epoxyexample.model.entity.Friend

class FriendHolder {

    private var friend: Friend? = null

    fun hold(friend: Friend) {
        this.friend = friend
    }

    fun getOrNull(): Friend? = friend

    fun release() {
        friend = null
    }

}
