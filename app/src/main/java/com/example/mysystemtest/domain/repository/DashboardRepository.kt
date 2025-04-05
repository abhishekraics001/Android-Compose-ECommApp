package com.example.mysystemtest.domain.repository

import com.example.mysystemtest.data.utils.ResponseResult
import com.example.mysystemtest.domain.model.DashboardModel
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {
    suspend fun getSections(): Flow<ResponseResult<List<DashboardModel>>>
}