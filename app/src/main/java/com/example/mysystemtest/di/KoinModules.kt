package com.example.mysystemtest.di

import com.example.mysystemtest.data.remote.ApiClient
import com.example.mysystemtest.data.remote.ApiService
import com.example.mysystemtest.data.repository.DashboardRepositoryImpl
import com.example.mysystemtest.domain.repository.DashboardRepository
import com.example.mysystemtest.domain.usecases.DashboardUseCase
import com.example.mysystemtest.domain.usecases.DashboardUseCaseImpl
import com.example.mysystemtest.prasention.viewModel.DashboardViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModel

import org.koin.dsl.module
import java.util.concurrent.TimeUnit

object KoinModules {

    private val repositoryModule = module {


       /* viewModel {
            DashboardViewModel(
                useCase = get()
            )
        }*/
        viewModel { DashboardViewModel(get()) }
       // factory { DashboardViewModel(get()) } // Assuming DashboardViewModel needs two dependencies
        single<DashboardRepository> { DashboardRepositoryImpl(get()) }
        single<DashboardUseCase> { DashboardUseCaseImpl(get()) }



        // Provide ApiClient, inject OkHttpClient into ApiClient
        //single { ApiClient(get()) }\
        single<ApiService> { ApiClient.getRetrofitApiService(get()) }
    }


   /* val appModules = listOf(repositoryModule, networkModule,)

    fun inject() = appModules*/

    val appModules = listOf(repositoryModule)

/*    //We can also load & inject the KOIN at runtime or dynamic
    private val loadSignupKoinModule by lazy{
        loadKoinModules(repositoryModule)
    }

    fun inject() = loadSignupKoinModule*/

}