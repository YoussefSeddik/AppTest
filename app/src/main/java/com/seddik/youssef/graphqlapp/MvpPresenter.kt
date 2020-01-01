package com.seddik.youssef.graphqlapp

interface MvpPresenter<View> {
    fun attachView(view: View)
}