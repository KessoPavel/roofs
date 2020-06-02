package com.roof.roofs.ui.roofList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roof.roofs.data.Repository
import com.roof.roofs.domain.RoofOrder

class RoofListViewModel : ViewModel(), Repository.UpdateListener {
    val roofOrderList: MutableLiveData<List<RoofOrder>> = MutableLiveData()

    init {
        Repository.addListener(this)
    }

    fun getOrderList() {
        roofOrderList.value = Repository.getRoofOrderList()
    }

    override fun newOrder() {
        roofOrderList.value = Repository.getRoofOrderList()
    }

    override fun onCleared() {
        super.onCleared()
        Repository.removeListener(this)
    }
}