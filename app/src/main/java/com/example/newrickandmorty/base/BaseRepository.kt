package com.example.newrickandmorty.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.newrickandmorty.common.resource.Resource
import kotlinx.coroutines.Dispatchers

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = request()))
        } catch (ioException: Exception) {
            emit(
                Resource.Error(
                    data = null, message = ioException.localizedMessage ?: "Error Occurred!"
                )
            )
        }
    }

    protected fun <ValueDto : Any, Value : Any> doPagingRequest(
        pagingSource: BasePagingSource<ValueDto, Value>,
        pageSize: Int = 10,
        prefetchDistance: Int = pageSize,
        enablePlaceholder: Boolean = true,
        initialLoadSize: Int = pageSize * 3,
        maxSize: Int = Int.MAX_VALUE,
        jumpThreshold: Int = Int.MIN_VALUE,
    ): LiveData<PagingData<ValueDto>> {
        return Pager(
            config = PagingConfig(
                pageSize,
                prefetchDistance,
                enablePlaceholder,
                initialLoadSize,
                maxSize,
                jumpThreshold
            ),
            pagingSourceFactory = {
                pagingSource
            }
        ).liveData
    }
}