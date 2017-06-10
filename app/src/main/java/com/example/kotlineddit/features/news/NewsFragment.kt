package com.example.kotlineddit.features.news

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlineddit.R
import com.example.kotlineddit.commons.RxBaseFragment
import com.example.kotlineddit.commons.extensions.inflate
import com.example.kotlineddit.features.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*


class NewsFragment : RxBaseFragment() {
    private val newsManager by lazy { NewsManager() }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

        //Create dummy data of the news adapter
        if (savedInstanceState == null) {
            requestNews()
        }
    }


    private fun requestNews() {
//        (news_list.adapter as NewsAdapter).addNews(news)
        val subscription = newsManager.getNews()
                .subscribe(
                        {
                            retrievedNews ->
                            (news_list.adapter as NewsAdapter).addNews(retrievedNews)
                        },
                        {
                            e ->
                            Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                        }
                )
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}