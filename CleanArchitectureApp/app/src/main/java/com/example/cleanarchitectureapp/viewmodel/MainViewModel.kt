package com.example.cleanarchitectureapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureapp.model.CoinListState
import com.example.domain.common.Resource
import com.example.domain.use_case.get_coins.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinUseCase
): ViewModel() {

    private val _state = MutableLiveData<CoinListState>()
    val state: LiveData<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.postValue(
                        CoinListState(coins = result.data ?: emptyList())
                    )
                }
                is Resource.Error -> {
                    _state.postValue(
                        CoinListState(error = result.message ?: "An unexpected error occurred.")
                    )
                }
                is Resource.Loading -> {
                    _state.postValue(
                        CoinListState(isLoading = true)
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}