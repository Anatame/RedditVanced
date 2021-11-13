package com.anatame.redditxml.data.remote.dto

import com.anatame.redditxml.data.remote.dto.Image

data class Preview(
    val enabled: Boolean,
    val images: List<Image>
)