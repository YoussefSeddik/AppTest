package com.seddik.youssef.graphqlapp.main

import com.apollographql.apollo.api.Response

object MainContract {
    interface Peresenter {
        fun getAllPosts()
        fun createNewPost(title: String, description: String)
    }

    interface View {
        fun display(posts: List<AllPostsQuery.AllPost>?)
        fun createPostSucess(sucess: Boolean)

    }
}