package com.anatame.redditxml.data.remote

import com.anatame.redditxml.data.remote.SubDetailDto.AboutData
import com.anatame.redditred.data.remote.dto.Data
import retrofit2.Response
import retrofit2.http.GET

interface RedditApi {
    @GET("/r/memes.json")
    suspend fun getSubreddit(): Response<Data>

    @GET("/r/memes/about.json")
    suspend fun getSubredditDetails(): Response<AboutData>
}