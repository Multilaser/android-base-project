package br.com.multilaser.example.baseproject.presentation.login

import br.com.multilaser.example.baseproject.domain.interactor.LoginInteractor
import br.com.multilaser.example.baseproject.extensions.request
import io.reactivex.disposables.CompositeDisposable

class LoginPresenter(
    private val view: LoginContract.View,
    private val interactor: LoginInteractor
) : LoginContract.Presenter {

    private lateinit var disposable: CompositeDisposable

    override fun onCreate() {
        disposable = CompositeDisposable()
    }

    override fun makeLogin(login: String, password: String) {
        disposable.request(interactor.login(login, password),
            {
                // success
                view.loginSuccess()
            }, {
                // error
                view.loginError(it)
            }, {
                // onTerminate
            })
    }

    override fun onDestroy() {
        if (!disposable.isDisposed) disposable.dispose()
    }
}