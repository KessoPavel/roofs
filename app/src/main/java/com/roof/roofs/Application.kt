package com.roof.roofs

import android.app.Application
import com.roof.roofs.data.RoofOrderRepository

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        RoofOrderRepository.init(this)
    }
}