package com.seddik.youssef.graphqlapp.main

import com.apollographql.apollo.api.Response

object MainContract {
    interface Peresenter {
        fun getAllPosts(data: Response<AllPostsQuery.Data>?)
        fun createNewPost(title: String, description: String)
    }

    interface View {
        fun display()

    }
}