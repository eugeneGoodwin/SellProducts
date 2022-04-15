package com.vortex.soft.sellproducts.base.presentation.tool.extentions

import android.graphics.Paint
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.StrikethroughSpan
import android.text.style.URLSpan
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

fun TextView.setUrl(url: String, str: String, subStr: String) {
    val indexSubstring = str.indexOf(subStr, 0)
    val spannableStr = SpannableString(str)
    spannableStr.setSpan(URLSpan(url), indexSubstring, indexSubstring + subStr.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    setText(spannableStr)
    setMovementMethod(LinkMovementMethod.getInstance())
}

fun TextView.setClickable(clickableSpan: ClickableSpan, str: String, subStr: String) {
    val indexSubstring = str.indexOf(subStr, 0)
    val spannableStr = SpannableString(str)
    spannableStr.setSpan(clickableSpan, indexSubstring, indexSubstring + subStr.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    setText(spannableStr)
    setMovementMethod(LinkMovementMethod.getInstance())
}

fun TextView.setStrike(str: String, subStr: String) {
    val indexSubstring = str.indexOf(subStr, 0)
    val spannableStr = SpannableString(str)
    spannableStr.setSpan(StrikethroughSpan(), indexSubstring, indexSubstring + subStr.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    setText(spannableStr)
    setMovementMethod(LinkMovementMethod.getInstance())
}

fun TextView.setStrikeLine() {
    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

fun TextView.clearStrikeLine() {
    paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
}

fun TextView.initUnderlineText() {
    paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
}

fun TextInputLayout.turnError(errorStr: String) {
    isErrorEnabled = true
    error = errorStr
}

fun TextInputLayout.clearError() {
    error = null
    isErrorEnabled = false
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}