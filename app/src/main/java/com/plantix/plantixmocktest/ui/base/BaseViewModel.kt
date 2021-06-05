package com.plantix.plantixmocktest.ui.base

import androidx.lifecycle.ViewModel
import com.plantix.plantixmocktest.data.repository.DataRepository

abstract class BaseViewModel(val dataRepository: DataRepository) : ViewModel()
