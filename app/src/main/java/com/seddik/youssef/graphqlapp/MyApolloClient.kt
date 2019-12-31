package com.seddik.youssef.graphqlapp

import com.apollographql.apollo.ApolloClient

object MyApolloClient {
    val BASE_URL: String = "https://api.graph.cool/simple/v1/ck4clhep22io50181hdqn6ism/"
    lateinit var myApolloClient: ApolloClient

    fun getApolloClient(): ApolloClient {
        myApolloClient = ApolloClient.builder()
            .serverUrl(BASE_URL)
            .build()
        return myApolloClient
    }

}