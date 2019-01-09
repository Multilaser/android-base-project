package br.com.multilaser.example.baseproject.presentation.login

import br.com.multilaser.example.baseproject.di.Injection
import br.com.multilaser.example.baseproject.domain.interactor.LoginInteractor
import br.com.multilaser.example.baseproject.repository.remote.LoginRepository
import br.com.multilaser.example.baseproject.repository.remote.api.LoginApi

internal class LoginInjection {

    val interactor by lazy {
        val repository = LoginRepository(
            loginApi = Injection.retrofit.create(LoginApi::class.java),
            preferences = Injection.preferences
        )
        LoginInteractor(repository)
    }
}