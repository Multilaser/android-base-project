package br.com.multilaser.example.baseproject.presentation.login

import br.com.multilaser.example.baseproject.core.common.BasePresenter
import br.com.multilaser.example.baseproject.core.common.BaseView

interface LoginContract {

    interface Presenter : BasePresenter {
        fun makeLogin(login: String, password: String)
    }

    interface View : BaseView<Presenter> {
        fun loginSuccess()
        fun loginError(error: Throwable)
    }
}