package com.example.kotlineddit.features.news

import com.example.kotlineddit.api.RestAPI
import com.example.kotlineddit.commons.RedditNews
import com.example.kotlineddit.commons.RedditNewsItem
import rx.Observable

class NewsManager(private val api: RestAPI = RestAPI()) {

    fun getNews(after: String, limit: String = "10"): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news
                )
                subscriber.onNext(news)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}