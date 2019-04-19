package com.beeete2.android.epoxyexample.ui.friend.list

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.beeete2.android.epoxyexample.R
import com.beeete2.android.epoxyexample.ext.text
import com.beeete2.android.epoxyexample.model.entity.Friend
import com.beeete2.android.epoxyexample.model.entity.Gender

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class FriendItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val nameView by lazy { findViewById<TextView>(R.id.name) }
    private val phoneticView by lazy { findViewById<TextView>(R.id.phonetic) }
    private val genderView by lazy { findViewById<TextView>(R.id.gender) }

    init {
        inflate(context, R.layout.friend_item, this)
    }

    @TextProp
    fun setName(text: CharSequence) {
        nameView.text = text
    }

    @TextProp
    fun setPhonetic(text: CharSequence) {
        phoneticView.text = text
    }

    @TextProp
    fun setGender(text: CharSequence) {
        genderView.text = text
    }

    @CallbackProp
    fun setClickListener(clickListener: OnClickListener?) {
        setOnClickListener(clickListener)
    }

}
