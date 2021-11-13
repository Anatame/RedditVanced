package com.anatame.redditxml.data.remote.dto

import com.anatame.redditxml.data.remote.dto.Child

data class DataX(
    val after: String,
    val before: Any,
    val children: List<Child>,
    val dist: Int,
    val geo_filter: Any,
    val modhash: String
)