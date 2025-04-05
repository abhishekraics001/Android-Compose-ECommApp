package com.example.mysystemtest.data.remote

import com.example.mysystemtest.domain.model.DashboardModel
import retrofit2.http.GET

interface ApiService {

    @GET("/b/5BEJ")
    suspend fun getSections(): List<DashboardModel>
}