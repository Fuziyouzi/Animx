package com.example.animex.base

import android.util.Patterns
import android.view.View
import com.example.animex.core.EmailNotMatchException
import com.example.animex.core.EmptyFieldException
import com.example.animex.core.PasswordMismatchException

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}



fun CharSequence.empty(): Boolean {
    if (this.isBlank() || this.length <=3 ) throw EmptyFieldException()
    return true
}

fun CharSequence.checkEmails(s: String): Boolean {
    if (!Patterns.EMAIL_ADDRESS.matcher(this).matches()
        || this != s
    ) throw EmailNotMatchException()
    return true
}

fun CharSequence.checkEmail(): Boolean {
    if (!Patterns.EMAIL_ADDRESS.matcher(this).matches()
    ) throw EmailNotMatchException()
    return true
}

fun CharSequence.checkPass(s: String): Boolean{
    if (this.isBlank() || this.length <= 4 || this != s) throw PasswordMismatchException()
    return true
}
