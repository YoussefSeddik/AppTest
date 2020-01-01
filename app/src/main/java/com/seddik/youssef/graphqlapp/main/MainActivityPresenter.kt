package com.seddik.youssef.graphqlapp.main

import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.seddik.youssef.graphqlapp.MyApolloClient
import com.seddik.youssef.graphqlapp.UserLayoutViewModel_
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityPresenter() : MainContract.Peresenter, MainContract.View {
    private lateinit var postList: List<AllPostsQuery.AllPost>

    override fun getAllPosts(data: Response<AllPostsQuery.Data>?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createNewPost(title: String, description: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun display() {
        recyclerView.buildModelsWith {
            allPosts.forEachIndexed { index, post ->
                UserLayoutViewModel_()
                    .id(index)
                    .title(post.title())
                    .desc(post.description())
                    .addTo(it)
            }
        }
    }

    //////////////////////////////////////////////////////
    /*
    Get All posts request
     */
    fun getPosts() {
        MyApolloClient.getApolloClient().query(
            AllPostsQuery.builder().build()
        ).enqueue(object : ApolloCall.Callback<AllPostsQuery.Data>() {
            override fun onResponse(response: Response<AllPostsQuery.Data>) {
//                peresenter.getAllPosts(response)
                if (!response.hasErrors()) {
                    response.data()?.allPosts()
                }
            }

            override fun onFailure(e: ApolloException) {
                Log.e("onFailure", "onFailuree${e.message}")
            }
        })
    }


}