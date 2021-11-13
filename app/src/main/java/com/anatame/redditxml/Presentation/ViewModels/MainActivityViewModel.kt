package com.anatame.redditxml.Presentation.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anatame.redditxml.common.Resource
import com.anatame.redditxml.data.remote.SubDetailDto.SubRedditDetail
import com.anatame.redditxml.domain.use_case.get_data.GetData
import com.anatame.redditxml.domain.use_case.get_data.GetSubRedditDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivityViewModel  (
    private val getData: GetData = GetData(),
    private val getSubRedditDetails: GetSubRedditDetail = GetSubRedditDetail()
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state

    private val _subIcon = MutableStateFlow(SubRedditDetail())
    val subIcon: StateFlow<SubRedditDetail> = _subIcon

    init {
        getPosts()
        getSubDetails()
    }

    private fun getPosts() {
        getData().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = HomeScreenState(posts = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = HomeScreenState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = HomeScreenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getSubDetails() {
        getSubRedditDetails().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _subIcon.value = result.data!!
                }
                is Resource.Error -> {
                    _state.value = HomeScreenState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = HomeScreenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}