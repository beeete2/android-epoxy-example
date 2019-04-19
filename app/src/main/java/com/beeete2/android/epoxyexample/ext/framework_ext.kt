package com.beeete2.android.epoxyexample.ext

import android.text.Editable
import android.text.Spanned
import android.text.TextWatcher
import android.widget.EditText
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(@IdRes id: Int) {
    findNavController().navigate(id)
}

/**
 * Set the given text on the textview.
 *
 * @return True if the given text is different from the previous text on the textview.
 */
fun EditText.setTextIfDifferent(newText: CharSequence?): Boolean {
    if (!isTextDifferent(newText, text)) {
        // Previous text is the same. No op
        return false
    }

    setText(newText)
    // Since the text changed we move the cursor to the end of the new text.
    // This allows us to fill in text programmatically with a different value,
    // but if the user is typing and the view is rebound we won't lose their cursor position.
    setSelection(newText?.length ?: 0)
    return true
}

/**
 * @return True if str1 is different from str2.
 *
 *
 * This is adapted from how the Android DataBinding library binds its text views.
 */
fun isTextDifferent(str1: CharSequence?, str2: CharSequence?): Boolean {
    if (str1 === str2) {
        return false
    }
    if (str1 == null || str2 == null) {
        return true
    }
    val length = str1.length
    if (length != str2.length) {
        return true
    }

    if (str1 is Spanned) {
        return str1 != str2
    }

    for (i in 0 until length) {
        if (str1[i] != str2[i]) {
            return true
        }
    }
    return false
}

class SimpleTextWatcher(val onTextChanged: (newText: String) -> Unit) : TextWatcher {
    override fun afterTextChanged(s: Editable) {
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        onTextChanged(s.toString())
    }
}