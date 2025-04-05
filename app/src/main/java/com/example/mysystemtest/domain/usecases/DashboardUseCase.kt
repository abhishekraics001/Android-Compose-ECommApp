package com.example.mysystemtest.domain.usecases

import com.example.mysystemtest.data.utils.ResponseResult
import com.example.mysystemtest.domain.model.DashboardModel
import kotlinx.coroutines.flow.Flow

interface DashboardUseCase {
    suspend fun invokew(): Flow<ResponseResult<List<DashboardModel>>>
}