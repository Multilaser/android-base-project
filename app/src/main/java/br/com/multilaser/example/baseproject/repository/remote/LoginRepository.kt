package br.com.multilaser.example.baseproject.repository.remote

import android.content.SharedPreferences
import br.com.multilaser.example.baseproject.domain.model.User
import br.com.multilaser.example.baseproject.repository.remote.api.LoginApi
import io.reactivex.Observable

class LoginRepository(private val loginApi: LoginApi,
                      private val preferences: SharedPreferences) {

    fun login(login: String, password: String): Observable<User> {
        return loginApi.login(login, password)
    }

    fun saveAuthToken() {
        preferences.edit()
            .putString("TOKEN", "token")
            .apply()
    }
}