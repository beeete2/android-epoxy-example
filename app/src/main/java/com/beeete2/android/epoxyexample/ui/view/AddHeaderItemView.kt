package com.beeete2.android.epoxyexample.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.beeete2.android.epoxyexample.R
import com.beeete2.android.epoxyexample.ext.SimpleTextWatcher
import com.beeete2.android.epoxyexample.ext.setTextIfDifferent

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class AddHeaderItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val header by lazy { findViewById<TextView>(R.id.header) }

    init {
        inflate(context, R.layout.add_header_item, this)
    }

    @TextProp
    fun setHeader(text: CharSequence) {
        header.text = text
    }

}
