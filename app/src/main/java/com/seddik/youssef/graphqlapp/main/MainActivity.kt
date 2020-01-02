package com.seddik.youssef.graphqlapp.main

import AllPostsQuery
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.seddik.youssef.graphqlapp.BasePresenter
import com.seddik.youssef.graphqlapp.R
import com.seddik.youssef.graphqlapp.UserLayoutViewModel_
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var title: String
    private lateinit var desc: String

    val presenter = MainActivityPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter.getAllPosts()


        send.setOnClickListener {
            title = title_et.text.toString()
            desc = desc_et.text.toString()
            presenter.createNewPost(title, desc)
            title_et.text.clear()
            desc_et.text.clear()

        }
    }

    override fun onResume() {
        super.onResume()
        if (!presenter.isViewAttached()) {
            presenter.attachView(this)
        }
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

    override fun display(posts: List<AllPostsQuery.AllPost>?) {
        if (posts != null) {
            runOnUiThread {
                setUpRecyclerView(posts)
            }
        }
    }

    override fun createPostSucess(sucess: Boolean) {
        if (sucess) {
            runOnUiThread {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                presenter.getAllPosts()
            }
        }
    }
}

