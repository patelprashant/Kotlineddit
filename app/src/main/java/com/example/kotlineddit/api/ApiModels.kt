package com.example.kotlineddit.api

class RedditNewsResponse (val data: RedditDataResponse)

class RedditDataResponse(val children: List<RedditChildrenResponse>,
                         val after: String?,
                         val before: String?)
class RedditChildrenResponse (val data: RedditNewsDataResponse)

class RedditNewsDataResponse(
        val author: String,
        val title: String,
        val num_comments: Int,
        val created: Long,
        val thumbanil: String,
        val url: String
)