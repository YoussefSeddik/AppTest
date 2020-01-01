package com.seddik.youssef.graphqlapp

import AllPostsQuery
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apollographql.apollo.api.Response
import com.seddik.youssef.graphqlapp.main.MainActivityPresenter
import com.seddik.youssef.graphqlapp.main.MainContract
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.Peresenter {


    private lateinit var title: String
    private lateinit var desc: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainActivityPersenter = MainActivityPresenter(this)
        mainActivityPersenter.getPosts()

    }

    fun setUpRecyclerView(allPosts: List<AllPostsQuery.AllPost>) {

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
    override fun createNewPost(title: String, description: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllPosts(data: Response<AllPostsQuery.Data>?) {
        runOnUiThread {
            //data?.data()?.allPosts()?.let { setUpRecyclerView(it) }
        }
    }


}
//        send.setOnClickListener {
//            title = title_et.text.toString()
//            desc = desc_et.text.toString()
//            newPost(title, desc)
//            title_et.text.clear()
//            desc_et.text.clear()
//        }


//////////////////////////////////////////////////////
/*
Create new post request
 */
//    private fun newPost(title: String, desc: String) {
//        MyApolloClient.getApolloClient().mutate(
//            NewPostMutation.builder()
//                .title(title)
//                .description(desc)
//                .build()
//        ).enqueue(object : ApolloCall.Callback<NewPostMutation.Data>() {
//            override fun onResponse(response: Response<NewPostMutation.Data>) {
//                getAllPosts()
//            }
//
//            override fun onFailure(e: ApolloException) {
//            }
//
//        })

//    }
