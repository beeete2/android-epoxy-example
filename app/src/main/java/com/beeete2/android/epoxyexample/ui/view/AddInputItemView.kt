package com.beeete2.android.epoxyexample.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.*
import com.beeete2.android.epoxyexample.R
import com.beeete2.android.epoxyexample.ext.SimpleTextWatcher
import com.beeete2.android.epoxyexample.ext.setTextIfDifferent


@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class AddInputItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val editText by lazy { findViewById<EditText>(R.id.friend_edit_text) }
    private val editTextWatcher = SimpleTextWatcher { onEditTextChanged?.invoke(it) }

    @set:TextProp
    var text: CharSequence? = null

    @set:TextProp
    var hint: CharSequence? = null

    @set:CallbackProp
    var onEditTextChanged: ((newText: String) -> Unit)? = null

    init {
        inflate(context, R.layout.add_input_item, this)
    }

    @AfterPropsSet
    fun postBindSetup() {
        editText.also {
            it.setTextIfDifferent(text)
            it.hint = hint
            it.removeTextChangedListener(editTextWatcher)
            it.addTextChangedListener(editTextWatcher)
        }
    }

    @OnViewRecycled
    fun onViewRecycled() {
        editText.removeTextChangedListener(editTextWatcher)
    }

}
