package br.com.multilaser.example.baseproject.repository.remote.api

import br.com.multilaser.example.baseproject.domain.model.User
import io.reactivex.Observable
import retrofit2.http.POST

interface LoginApi {

    @POST("/auth")
    fun login(login: String, password: String): Observable<User>
}