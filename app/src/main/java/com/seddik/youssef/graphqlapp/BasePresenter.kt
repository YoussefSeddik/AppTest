package com.seddik.youssef.graphqlapp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel

abstract class BasePresenter<V> : MvpPresenter<V> ,ViewModel(){
    var view: V? = null
    protected var viewLifecycle: Lifecycle? = null

    override fun attachView(view: V?, viewLifecycle: Lifecycle) {
        this.viewLifecycle = viewLifecycle
        this.view = view

    }

    fun isViewAttached(): Boolean {
        return view != null
    }

    override fun disAttachViewe(view: V?, lifecycle: Lifecycle) {
        this.viewLifecycle = null
        this.view = null
        onCleared()

    }



}