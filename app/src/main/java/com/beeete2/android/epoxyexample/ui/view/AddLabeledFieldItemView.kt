package com.beeete2.android.epoxyexample.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.beeete2.android.epoxyexample.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class AddLabeledFieldItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val label by lazy { findViewById<TextView>(R.id.label) }
    private val value by lazy { findViewById<TextView>(R.id.value) }

    init {
        inflate(context, R.layout.add_labeled_field_item, this)
    }

    @TextProp
    fun setLabel(text: CharSequence) {
        label.text = text
    }

    @TextProp
    fun setValue(text: CharSequence) {
        value.text = text
    }

}
