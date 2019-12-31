package com.seddik.youssef.graphqlapp

import AllPostsQuery
import NewPostMutation
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var title: String
    private lateinit var desc: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAllPosts()
        send.setOnClickListener {
            title = title_et.text.toString()
            desc = desc_et.text.toString()
            newPost(title, desc)
            title_et.text.clear()
            desc_et.text.clear()
        }
    }


    //////////////////////////////////////////////////////
    /*
    Get All posts request
     */
    private fun getAllPosts() {
        MyApolloClient.getApolloClient().query(
            AllPostsQuery.builder().build()
        ).enqueue(object : ApolloCall.Callback<AllPostsQuery.Data>() {
            override fun onResponse(response: Response<AllPostsQuery.Data>) {
                runOnUiThread {
                    setUpRecyclerView(response.data()!!.allPosts())
                }
            }

            override fun onFailure(e: ApolloException) {}
        })
    }


    //////////////////////////////////////////////////////
    /*
    Create new post request
     */
    private fun newPost(title: String, desc: String) {
        MyApolloClient.getApolloClient().mutate(
            NewPostMutation.builder()
                .title(title)
                .description(desc)
                .build()
        ).enqueue(object : ApolloCall.Callback<NewPostMutation.Data>() {
            override fun onResponse(response: Response<NewPostMutation.Data>) {
                getAllPosts()
            }

            override fun onFailure(e: ApolloException) {
            }

        })

    }

    //////////////////////////////////////////////////////
    /*
    Setup recyclerview data with epoxy
     */
    private fun setUpRecyclerView(allPosts: List<AllPostsQuery.AllPost>) {
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
}
