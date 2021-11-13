package com.anatame.redditxml.domain.use_case.get_data

import com.anatame.redditxml.common.Resource
import com.anatame.redditxml.data.remote.PostDetail
import com.anatame.redditxml.data.remote.RetrofitInstance
import com.anatame.redditxml.data.remote.dto.toPostDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetData {

    operator fun invoke(): Flow<Resource<List<PostDetail>>> = flow {
      try {
          emit(Resource.Loading())
          val postDetails = RetrofitInstance.api.getSubreddit()
              .body()!!.data.children.map { it.data.toPostDetail() }
          emit(Resource.Success(postDetails))
      }
      catch(e: IOException) { }
      catch (e: HttpException) { }
    }

}