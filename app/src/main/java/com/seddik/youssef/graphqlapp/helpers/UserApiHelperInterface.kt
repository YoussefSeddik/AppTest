package com.baianat.app.data.api.user


import com.apollographql.apollo.api.Response
import io.reactivex.Observable

interface UserApiHelperInterface {
    fun getPostsResponse(): Observable<Response<AllPostsQuery.Data>>
//    fun createewPost(title:String,desc:String):Observable<Response<New.Data>>
}