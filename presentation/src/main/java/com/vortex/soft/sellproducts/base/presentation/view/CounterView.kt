package com.vortex.soft.sellproducts.base.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorRes

import androidx.annotation.StringRes
import com.vortex.soft.sellproducts.presentation.R

interface CounterListner {
    fun onIncClick(value: String)
    fun onDecClick(value: String)
}

class CounterView: LinearLayout, View.OnClickListener {

    private var itemCounterValue: TextView? = null
    private var incButton: Button? = null
    private var decButton: Button? = null
    private var rootView: LinearLayout? = null
    private var listener: CounterListner? = null

    constructor(context: Context): super(context) {
        init(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        init(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {
        inflate(context, R.layout.item_counter, this)
        rootView = findViewById(R.id.root_view) as LinearLayout?
        itemCounterValue = findViewById(R.id.valueCounter) as TextView?
        incButton = findViewById(R.id.incButton) as Button?
        decButton = findViewById(R.id.decButton) as Button?
        incButton?.setOnClickListener(this)
        decButton?.setOnClickListener(this)
    }


    fun setStartCounterValue(startValue: String?): CounterView {
        if (itemCounterValue != null) itemCounterValue?.setText(startValue)
        return this
    }

    fun setStartCounterValue(@StringRes startValue: Int): CounterView {
        if (itemCounterValue != null) itemCounterValue?.setText(getString(startValue))
        return this
    }

    fun setCounterListener(counterListener: CounterListner?): CounterView {
        listener = counterListener
        return this
    }

    fun getCounterValue(): String {
        var text = ""
        if (itemCounterValue != null) text = itemCounterValue?.getText().toString()
        return text
    }

    private fun getString(@StringRes textResourceValue: Int): String {
        return getContext().getString(textResourceValue)
    }

    fun setColor(@ColorRes left: Int, @ColorRes right: Int, @ColorRes text: Int): CounterView {
        incButton?.setBackgroundColor(getColor(right))
        decButton?.setBackgroundColor(getColor(left))
        itemCounterValue?.setTextColor(getColor(text))
        return this
    }

    private fun getColor(@ColorRes colorRes: Int): Int {
        return getContext().getResources().getColor(colorRes)
    }

    override fun onClick(view: View) {
        var value = 0
        value = itemCounterValue?.getText().toString().toInt()
        val i: Int = view.getId()
        if (i == R.id.incButton) {
            value++
            itemCounterValue?.setText(value.toString())
            if (listener != null) listener?.onIncClick(itemCounterValue?.getText().toString())
        } else if (i == R.id.decButton) {
            value--
            if (value < 1) {
                value = 1
            }
            itemCounterValue?.setText(value.toString())
            if (listener != null) listener?.onDecClick(itemCounterValue?.getText().toString())
        }
    }
}
