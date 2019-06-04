package com.beeete2.android.epoxyexample.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.beeete2.android.epoxyexample.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class MenuItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val overlay by lazy { findViewById<View>(R.id.click_overlay) }

    private val label by lazy { findViewById<TextView>(R.id.menu_label) }

    init {
        inflate(context, R.layout.menu_item, this)
    }

    @TextProp
    fun setText(text: CharSequence) {
        label.text = text
    }

    @CallbackProp
    fun setClickListener(listener: OnClickListener?) {
        overlay.setOnClickListener(listener)
    }

}
