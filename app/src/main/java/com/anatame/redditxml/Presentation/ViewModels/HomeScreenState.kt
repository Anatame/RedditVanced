package com.anatame.redditxml.Presentation.ViewModels

import com.anatame.redditxml.data.remote.PostDetail

data class HomeScreenState(
    val isLoading: Boolean = false,
    val posts: List<PostDetail> = emptyList(),
    val error: String = ""
)
