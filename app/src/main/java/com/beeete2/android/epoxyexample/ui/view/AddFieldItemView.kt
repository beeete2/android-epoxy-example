package com.beeete2.android.epoxyexample.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.beeete2.android.epoxyexample.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class AddFieldItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val value by lazy { findViewById<TextView>(R.id.value) }

    init {
        ConstraintLayout.inflate(context, R.layout.add_field_item, this)
    }

    @TextProp
    fun setValue(text: CharSequence) {
        value.text = text
    }

}
