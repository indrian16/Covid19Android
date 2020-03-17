package io.indrian.covid19

import android.app.Application
import io.indrian.covid19.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Covid19App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(applicationContext)
            androidLogger(level = Level.DEBUG)
            modules(
                arrayListOf(
                    appModule
                )
            )
        }
    }
}