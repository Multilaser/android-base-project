package br.com.multilaser.example.baseproject.core

import android.app.Application
import android.preference.PreferenceManager
import br.com.multilaser.example.baseproject.di.Injection
import br.com.multilaser.example.baseproject.repository.remote.Api

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injection.init(
            retrofit = Api.retrofit(),
            preferences = PreferenceManager.getDefaultSharedPreferences(this)
        )
    }
}