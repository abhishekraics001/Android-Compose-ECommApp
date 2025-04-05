package com.example.mysystemtest.domain.usecases

import com.example.mysystemtest.data.utils.ResponseResult
import com.example.mysystemtest.domain.model.DashboardModel
import com.example.mysystemtest.domain.repository.DashboardRepository
import kotlinx.coroutines.flow.Flow

class DashboardUseCaseImpl(
    private val sectionRepository: DashboardRepository
) : DashboardUseCase {

   override suspend  fun invokew(): Flow<ResponseResult<List<DashboardModel>>> {
        return sectionRepository.getSections()
    }
}