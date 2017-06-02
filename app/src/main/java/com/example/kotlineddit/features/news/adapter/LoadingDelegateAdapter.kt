package com.example.kotlineddit.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.kotlineddit.R
import com.example.kotlineddit.commons.adapter.ViewType
import com.example.kotlineddit.commons.adapter.ViewTypeDelegateAdapter
import com.example.kotlineddit.commons.extensions.inflate

class LoadingDelegateAdapter: ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }
}

class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading)) {

}
