package com.beeete2.android.epoxyexample.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.*
import com.beeete2.android.epoxyexample.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class AddSwitchItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val _label by lazy { findViewById<TextView>(R.id.switch_label) }
    private val _switch by lazy { findViewById<SwitchCompat>(R.id.switcher) }

    @set:TextProp
    var label: CharSequence? = null

    @set:ModelProp
    var checked: Boolean? = null

    @set:CallbackProp
    var checkedChangeListener: CompoundButton.OnCheckedChangeListener? = null

    init {
        inflate(context, R.layout.add_switch_item, this)
    }

    @AfterPropsSet
    fun postBindSetup() {
        _label.text = label
        _switch.isChecked = checked ?: false
        _switch.setOnCheckedChangeListener(checkedChangeListener)
    }

    @OnViewRecycled
    fun onViewRecycled() {
        _switch.setOnCheckedChangeListener(null)
    }

}
