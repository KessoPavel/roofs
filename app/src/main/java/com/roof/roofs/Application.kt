package com.roof.roofs

import android.app.Application
import com.roof.roofs.data.Repository

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        Repository.init(this)
    }
}