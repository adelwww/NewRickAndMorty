package com.example.newrickandmorty.data.remote.pagingsource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.newrickandmorty.base.BasePagingSource
import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.data.models.LocationModel
import com.example.newrickandmorty.data.remote.apiservices.LocationApiService
import java.io.IOException

const val LOCATION_KEY = 1

class LocationPagingSource (
    private val service: LocationApiService
) : PagingSource<Int, LocationModel>(){


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationModel> {
        val page = params.key ?: LOCATION_KEY

        return try {
            val response = service.fetchLocation(page)
            val next = response.info.next
            val nextPageNumber = if (next == null) {
                null
            } else {
                Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
            }

            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, LocationModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}
