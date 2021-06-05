package com.plantix.plantixmocktest.ui.pages.namelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.plantix.plantixmocktest.data.db.entities.Name
import com.plantix.plantixmocktest.data.network.Resource
import com.plantix.plantixmocktest.data.repository.DataRepository
import com.plantix.plantixmocktest.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class NameListViewModel(dataRepository: DataRepository) : BaseViewModel(dataRepository) {

    private var _nameResponse: MutableLiveData<Resource<List<Name>>> =
        MutableLiveData()
    val nameResponse: LiveData<Resource<List<Name>>>
        get() = _nameResponse

    fun getRemoteNames() = viewModelScope.launch {
        _nameResponse.value = dataRepository.getRemoteNames()
    }

    fun getLocalNames() = dataRepository.getLocalNames()

    fun saveNames(names: List<Name>) = viewModelScope.launch {
        dataRepository.saveNames(names)
    }
}