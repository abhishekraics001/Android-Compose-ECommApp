package com.example.mysystemtest.base

import android.app.Application
import com.example.mysystemtest.di.KoinModules.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin




open class ApplicationBase  : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ApplicationBase)
            modules(modules = appModules)
        }

    }


}