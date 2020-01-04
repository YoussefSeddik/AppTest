package com.seddik.youssef.graphqlapp.main

import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.baianat.app.data.api.user.UserApiHelper
import com.seddik.youssef.graphqlapp.BasePresenter
import com.seddik.youssef.graphqlapp.MyApolloClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainActivityPresenter : BasePresenter<MainContract.View>(), MainContract.Peresenter {
    val userApiHelper = UserApiHelper(MyApolloClient)


    override fun createNewPost(title: String, desc: String) {

        MyApolloClient.getApolloClient().mutate(
            NewPostMutation.builder()
                .title(title)
                .description(desc)
                .build()
        ).enqueue(object : ApolloCall.Callback<NewPostMutation.Data>() {
            override fun onResponse(response: Response<NewPostMutation.Data>) {
                if (isViewAttached()) {
                    view?.createPostSucess(true)
                }
            }

            override fun onFailure(e: ApolloException) {
            }

        })
    }

    override fun getAllPosts() {
        val compositeDisposable: CompositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            userApiHelper.getPostsResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onNext = { view?.display(it.data()?.allPosts()) },
                    onError = { Log.e("faild", "get posts faild") }
                )

        )

    }


//        MyApolloClient.getApolloClient().query(
//            AllPostsQuery.builder().build()
//        ).enqueue(object : ApolloCall.Callback<AllPostsQuery.Data>() {
//            override fun onResponse(response: Response<AllPostsQuery.Data>) {
//                if (!response.hasErrors()) {
//                    if (isViewAttached()) {
//                        view?.display(response.data()?.allPosts())
//                    }
//                } else {
//                }
//            }
//
//            override fun onFailure(e: ApolloException) {
//            }
//        })
//    }

}


