package com.beeete2.android.epoxyexample.model.repository.memory

import com.beeete2.android.epoxyexample.model.entity.Friend
import com.beeete2.android.epoxyexample.model.entity.Gender
import com.beeete2.android.epoxyexample.model.repository.FriendRepository

class MemoryFriendRepository : FriendRepository {

    override fun fetchFriends(): List<Friend> {
        return listOf(
            Friend(
                id = 1,
                firstName = "beee",
                lastName = "te2",
                gender = Gender.MALE
            ),
            Friend(
                id = 2,
                firstName = "ben",
                lastName = "hoe",
                gender = Gender.MALE
            )
        )
    }

}
