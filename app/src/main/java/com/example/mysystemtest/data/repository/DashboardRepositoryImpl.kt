package com.example.mysystemtest.data.repository


import com.example.mysystemtest.data.remote.ApiService
import com.example.mysystemtest.data.utils.ResponseResult
import com.example.mysystemtest.domain.model.DashboardModel
import com.example.mysystemtest.domain.repository.DashboardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class DashboardRepositoryImpl(
    private val apiService: ApiService
) : DashboardRepository {

    override suspend fun getSections(): Flow<ResponseResult<List<DashboardModel>>> = flow {
        emit(ResponseResult.Loading)
        try {
            val sections = apiService.getSections()
            emit(ResponseResult.Success(sections))
        } catch (e: HttpException) {
            emit(ResponseResult.Error("Http error occurred: ${e.message()}"))
        } catch (e: IOException) {
            emit(ResponseResult.Error("Network error occurred: ${e.message}"))
        } catch (e: Exception) {
            emit(ResponseResult.Error("An unexpected error occurred: ${e.message}"))
        }
    }


}