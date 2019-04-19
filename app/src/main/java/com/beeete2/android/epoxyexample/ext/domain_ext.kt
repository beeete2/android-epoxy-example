package com.beeete2.android.epoxyexample.ext

import androidx.annotation.StringRes
import com.beeete2.android.epoxyexample.R
import com.beeete2.android.epoxyexample.model.entity.Friend
import com.beeete2.android.epoxyexample.model.entity.Gender

@get:StringRes
val Gender.text: Int
    get() = when (this) {
        Gender.MALE -> R.string.gender_male
        Gender.FEMALE -> R.string.gender_female
        Gender.UNKNOWN -> R.string.gender_unknown
        Gender.UNANSWERED -> R.string.gender_unanswered
    }

@get:StringRes
val Friend.blockText: Int
    get() = if (this.block) R.string.block_yes else R.string.block_no

@get:StringRes
val Friend.favoriteText: Int
    get() = if (this.favorite) R.string.favorite_yes else R.string.favorite_no
