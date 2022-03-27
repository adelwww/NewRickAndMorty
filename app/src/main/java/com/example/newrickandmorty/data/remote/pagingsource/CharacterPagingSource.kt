package com.example.newrickandmorty.data.remote.pagingsource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.data.remote.apiservices.CharacterApiService
import java.io.IOException

const val CHARACTER_KEY = 1

class CharacterPagingSource(
    private val service: CharacterApiService
) : PagingSource<Int, CharacterModel>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        val page = params.key ?: CHARACTER_KEY

        return try {
            val response = service.fetchCharacter(page)
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

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}
