package com.roof.roofs.ui.roofList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roof.roofs.data.RoofOrderRepository
import com.roof.roofs.domain.RoofOrder

class RoofListViewModel : ViewModel(), RoofOrderRepository.UpdateListener {
    val roofOrderList: MutableLiveData<List<RoofOrder>> = MutableLiveData()

    init {
        RoofOrderRepository.addListener(this)
    }

    fun getOrderList() {
        roofOrderList.value = RoofOrderRepository.getRoofOrderList()
    }

    override fun newOrder() {
        roofOrderList.value = RoofOrderRepository.getRoofOrderList()
    }

    override fun onCleared() {
        super.onCleared()
        RoofOrderRepository.removeListener(this)
    }
}