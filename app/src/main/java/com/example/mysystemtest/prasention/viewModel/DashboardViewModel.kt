package com.example.mysystemtest.prasention.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysystemtest.data.utils.ResponseResult
import com.example.mysystemtest.domain.model.DashboardModel
import com.example.mysystemtest.domain.usecases.DashboardUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class DashboardViewModel(
    private val useCase: DashboardUseCase
) : ViewModel() {

    //Example with Live data
   private val _sectionsStateL = MutableLiveData<ResponseResult<List<DashboardModel>>>()
   val sectionsStateL: LiveData<ResponseResult<List<DashboardModel>>> = _sectionsStateL


    private val _sectionsState = MutableStateFlow<ResponseResult<List<DashboardModel>>>(
        ResponseResult.Loading)
    val sectionsState: StateFlow<ResponseResult<List<DashboardModel>>> = _sectionsState

    fun fetchSections() {
        viewModelScope.launch {
           useCase.invokew().collect { result ->
                _sectionsState.value = result
            }
        }

//        10 AddTwo 20
//        100.AddTwo(20, 2)
    }

//    infix fun Int.AddTwo(x: Int, y: Int): Int {
//        return this + x
//    }

}