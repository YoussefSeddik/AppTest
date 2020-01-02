package com.baianat.app.data.api.user


import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.rx2.Rx2Apollo
import com.seddik.youssef.graphqlapp.MyApolloClient
import io.reactivex.Observable
import org.jetbrains.annotations.NotNull


class UserApiHelper(
    private val normalApollo: MyApolloClient
) : UserApiHelperInterface {
    override fun getPostsResponse(): Observable<Response<AllPostsQuery.Data>> {
        return Rx2Apollo.from(normalApollo.getApolloClient().query(AllPostsQuery.builder().build()))
    }

}