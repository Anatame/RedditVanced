package com.anatame.redditxml.data.remote

data class PostDetail(
    val title: String,
    val description: String,
    val subRedditName: String,
    val authorName: String,
    val thumbnail: String,
    val thumbnailHeight: Int,
    val thumbnailWidth: Int

)
