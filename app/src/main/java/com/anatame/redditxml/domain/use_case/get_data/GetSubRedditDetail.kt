package com.anatame.redditxml.domain.use_case.get_data

import com.anatame.redditred.data.remote.SubDetailDto.toSubRedditDetail
import com.anatame.redditxml.common.Resource
import com.anatame.redditxml.data.remote.RetrofitInstance
import com.anatame.redditxml.data.remote.SubDetailDto.SubRedditDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetSubRedditDetail {
    operator fun invoke(): Flow<Resource<SubRedditDetail>> = flow {
        try {
            emit(Resource.Loading<SubRedditDetail>())
            val subDetails = RetrofitInstance.api.getSubredditDetails()
                .body()!!.data.toSubRedditDetail()
            emit(Resource.Success<SubRedditDetail>(subDetails))
        }
        catch(e: IOException) { }
        catch (e: HttpException) { }
    }
}