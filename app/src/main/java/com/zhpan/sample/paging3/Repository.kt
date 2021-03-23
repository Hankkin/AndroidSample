package com.zhpan.sample.paging3

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zhpan.sample.model.Article
import com.zhpan.sample.server.ApiService
import kotlinx.coroutines.flow.Flow

/**
 *
 * @author zhangpan
 * @date 2021/3/23
 */
object Repository {
    private const val PAGE_SIZE = 50
    private val apiService = ApiService.create()

    fun fetchPagingData(): Flow<PagingData<Article>> {
        return Pager(config = PagingConfig(PAGE_SIZE), pagingSourceFactory = { ArticlePagingSource(apiService) }).flow
    }
}