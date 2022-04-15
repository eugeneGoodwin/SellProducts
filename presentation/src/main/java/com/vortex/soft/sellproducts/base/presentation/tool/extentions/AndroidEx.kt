package com.vortex.soft.sellproducts.base.presentation.tool.extentions

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

inline fun <reified T : ViewModel> Fragment.viewModelInit(model: T, body: T.() -> Unit): T {
    model.body()
    return model
}

fun <T> Fragment.observeOnce(liveData: MutableLiveData<T>, action: (t: T?) -> Unit) {
    liveData.observeOnce<T>(viewLifecycleOwner, Observer { it?.let{ action(it) } })
}

fun <T> MutableLiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<in T?>) {
    observe(lifecycleOwner, Observer {
        observer.onChanged(it)
        postValue(null)
    })
}

@ExperimentalCoroutinesApi
fun View.onClicked() = callbackFlow<Unit> {
    setOnClickListener { offer(Unit) }
    awaitClose { setOnClickListener(null) }
}

@FlowPreview
@ExperimentalCoroutinesApi
fun <T> Flow<T>.throttleFirst(windowDuration: Long): Flow<T> = flow {
    var lastEmissionTime = 0L
    collect { upstream ->
        val currentTime = System.currentTimeMillis()
        val mayEmit = currentTime - lastEmissionTime > windowDuration
        if (mayEmit) {
            lastEmissionTime = currentTime
            emit(upstream)
        }
    }
}