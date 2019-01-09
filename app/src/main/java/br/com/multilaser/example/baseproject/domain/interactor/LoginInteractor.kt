package br.com.multilaser.example.baseproject.domain.interactor

import br.com.multilaser.example.baseproject.core.common.raise
import br.com.multilaser.example.baseproject.domain.model.User
import br.com.multilaser.example.baseproject.repository.remote.LoginRepository
import io.reactivex.Observable

class LoginInteractor(private val repository: LoginRepository) {

    fun login(login: String, password: String): Observable<User> {
        return when {
            !isValidLogin(login, password) -> raise(IllegalArgumentException("Invalid login!"))
            else -> repository.login(login, password)
        }
    }

    private fun isValidLogin(login: String, password: String): Boolean {
        return login.isNotEmpty() && password.isNotEmpty()
    }
}