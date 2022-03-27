package com.example.newrickandmorty.data.remote.pagingsource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.newrickandmorty.base.BasePagingSource
import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.data.models.EpisodesModel
import com.example.newrickandmorty.data.remote.apiservices.EpisodeApiService
import java.io.IOException

const val EPISODE_KEY = 1

class EpisodePagingSource (
    private val service: EpisodeApiService
) : PagingSource<Int, EpisodesModel>(){


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodesModel> {
        val page = params.key ?: EPISODE_KEY

        return try {
            val response = service.fetchEpisode(page)
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

    override fun getRefreshKey(state: PagingState<Int, EpisodesModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}
