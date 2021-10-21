package com.venicio.starwars.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.venicio.starwars.data.model.People
import com.venicio.starwars.data.network.StarWarsService


class StarWarsPagingSource(
    private val service: StarWarsService,
) : PagingSource<Int, People>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, People> {
        val nextPage: Int = params.key ?: Constants.SWAPI_FIRST_PAGE_INDEX

        return try {
            val response = service.fetchPeopleList(nextPage)
            val peoples = response.results
            val nextPageNumber = if (peoples.isEmpty()) null else nextPage+1

            LoadResult.Page(
                data = peoples,
                prevKey = if (nextPage == Constants.SWAPI_FIRST_PAGE_INDEX) null else nextPage -1,
                nextKey = nextPageNumber
            )
        }
        catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, People>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }

}