package com.plantix.plantixmocktest.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.plantix.plantixmocktest.data.repository.DataRepository
import javax.inject.Inject

class BaseViewModelFactory @Inject constructor(
    private val dataRepository: DataRepository
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(DataRepository::class.java)
            .newInstance(dataRepository)
    }
}
