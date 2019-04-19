package com.beeete2.android.epoxyexample.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.*
import com.beeete2.android.epoxyexample.R
import com.beeete2.android.epoxyexample.model.entity.Gender

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class AddGenderOptionItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val genderGroup by lazy { findViewById<RadioGroup>(R.id.gender_group) }
    private val maleButton by lazy { findViewById<RadioButton>(R.id.gender_male) }
    private val femaleButton by lazy { findViewById<RadioButton>(R.id.gender_female) }
    private val unknownButton by lazy { findViewById<RadioButton>(R.id.gender_unknown) }

    @set:ModelProp
    var gender: Gender? = null

    @set:CallbackProp
    var maleCheckedChangeListener: CompoundButton.OnCheckedChangeListener? = null

    @set:CallbackProp
    var femaleCheckedChangeListener: CompoundButton.OnCheckedChangeListener? = null

    @set:CallbackProp
    var unknownCheckedChangeListener: CompoundButton.OnCheckedChangeListener? = null

    init {
        inflate(context, R.layout.add_gender_item, this)
    }

    @AfterPropsSet
    fun postBindSetup() {
        when (gender) {
            Gender.MALE -> maleButton.isChecked = true
            Gender.FEMALE -> femaleButton.isChecked = true
            Gender.UNKNOWN -> unknownButton.isChecked = true
            Gender.UNANSWERED -> genderGroup.clearCheck()
        }
        maleButton.setOnCheckedChangeListener(maleCheckedChangeListener)
        femaleButton.setOnCheckedChangeListener(femaleCheckedChangeListener)
        unknownButton.setOnCheckedChangeListener(unknownCheckedChangeListener)
    }

    @OnViewRecycled
    fun onViewRecycled() {
        maleButton.setOnCheckedChangeListener(null)
        femaleButton.setOnCheckedChangeListener(null)
        unknownButton.setOnCheckedChangeListener(null)
    }

}
