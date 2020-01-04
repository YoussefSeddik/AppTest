package com.seddik.youssef.graphqlapp

import androidx.lifecycle.Lifecycle

interface MvpPresenter<V> {
    fun attachView(view: V?, lifecycle: Lifecycle)
    fun disAttachViewe(view: V?, lifecycle: Lifecycle)
}