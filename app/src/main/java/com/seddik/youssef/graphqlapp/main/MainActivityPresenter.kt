package com.seddik.youssef.graphqlapp.main

import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.seddik.youssef.graphqlapp.BasePresenter
import com.seddik.youssef.graphqlapp.MyApolloClient

class MainActivityPresenter : BasePresenter<MainContract.View>(), MainContract.Peresenter {

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
        MyApolloClient.getApolloClient().query(
            AllPostsQuery.builder().build()
        ).enqueue(object : ApolloCall.Callback<AllPostsQuery.Data>() {
            override fun onResponse(response: Response<AllPostsQuery.Data>) {
                if (!response.hasErrors()) {
                    if (isViewAttached()) {
                        view?.display(response.data()?.allPosts())
                    }
                } else {
                }
            }

            override fun onFailure(e: ApolloException) {
            }
        })
    }

}


