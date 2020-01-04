package com.seddik.youssef.graphqlapp.di

import com.seddik.youssef.graphqlapp.main.MainActivity
import com.seddik.youssef.graphqlapp.main.MainActivityPresenter
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module

val mainModule = module {

    //    viewModel<MainActivityPresenter>(get())

    single<MainActivityPresenter> { MainActivityPresenter() }

}