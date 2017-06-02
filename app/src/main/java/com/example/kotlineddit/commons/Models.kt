package com.example.kotlineddit.commons

import com.example.kotlineddit.commons.adapter.AdapterConstants
import com.example.kotlineddit.commons.adapter.ViewType

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType(): Int  = AdapterConstants.NEWS
}