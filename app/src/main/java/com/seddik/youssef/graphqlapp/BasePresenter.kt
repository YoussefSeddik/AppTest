package com.seddik.youssef.graphqlapp

abstract class BasePresenter<View> : MvpPresenter<View> {
    protected var view: View? = null

    override fun attachView(view: View) {
        this.view = view
    }

    fun isViewAttached(): Boolean {
        return view != null
    }

}