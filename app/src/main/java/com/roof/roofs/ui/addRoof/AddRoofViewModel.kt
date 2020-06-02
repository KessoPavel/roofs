package com.roof.roofs.ui.addRoof

import androidx.lifecycle.ViewModel
import com.roof.roofs.data.Repository
import com.roof.roofs.domain.RoofOrder

class AddRoofViewModel : ViewModel() {

    fun addRoof(roofOrder: RoofOrder) {
        Repository.addRoofOrder(roofOrder)
    }
}