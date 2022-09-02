package com.crownedjester.soft.waterdrinkremainder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crownedjester.soft.waterdrinkremainder.domain.data_source.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HydrationViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _currentDailyHydration = MutableStateFlow(0)
    val currentDailyHydration: StateFlow<Int> get() = _currentDailyHydration

    private val _currentGoalHydration = MutableStateFlow(0)
    val currentGoalHydration: StateFlow<Int> get() = _currentGoalHydration

    init {
        getCurrentHydration()
        getGoalHydration()
    }

    private fun getCurrentHydration() {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.dailyHydration.collectLatest {
                _currentDailyHydration.emit(it)
            }
        }
    }

    private fun getGoalHydration() {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.hydrationGoal.collectLatest {
                _currentGoalHydration.emit(it)
            }
        }
    }

    fun updateDailyHydration(drankValue: Int) {
        viewModelScope.launch {
            dataStoreRepository.updateDailyHydration(drankAmount = _currentDailyHydration.value + drankValue)
        }
    }

    fun setNewHydrationGoal(value: Int) {
        viewModelScope.launch {
            dataStoreRepository.setNewHydrationGoal(value)
        }
    }


}