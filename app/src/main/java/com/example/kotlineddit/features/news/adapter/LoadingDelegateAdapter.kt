package com.example.kotlineddit.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.kotlineddit.R
import com.example.kotlineddit.commons.adapter.ViewType
import com.example.kotlineddit.commons.adapter.ViewTypeDelegateAdapter
import com.example.kotlineddit.commons.inflate

class LoadingDelegateAdapter: ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }
}

class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading)) {

}
