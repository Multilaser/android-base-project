package br.com.multilaser.example.baseproject.core.common

import io.reactivex.Observable

fun <T> raise(error: Throwable): Observable<T> {
    return Observable.error(error)
}