package com.example.kotlineddit.features.news.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.kotlineddit.commons.RedditNewsItem
import com.example.kotlineddit.commons.adapter.AdapterConstants
import com.example.kotlineddit.commons.adapter.ViewType
import com.example.kotlineddit.commons.adapter.ViewTypeDelegateAdapter

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.NEWS, NewsDelegateAdapter())
        items = ArrayList()
        items.add(loadingItem)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder != null) {
            delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder = delegateAdapters.get(viewType).onCreateViewHolder(parent as ViewGroup)

    override fun getItemViewType(position: Int): Int {
        return this.items[position].getViewType()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addNews(news: List<RedditNewsItem>) {
        //first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        //insert news and the loading at the end of the list
        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1) //includes loading item as well
    }

    fun clearAndAddNews(news: List<RedditNewsItem>) {
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())

        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    private fun getLastPosition() = if (items.lastIndex == -1) {
        0
    } else {
        items.lastIndex
    }

    fun getNews(): List<RedditNewsItem> {
        return items
                .filter { it.getViewType() == AdapterConstants.NEWS }
                .map { it as RedditNewsItem }
    }

}