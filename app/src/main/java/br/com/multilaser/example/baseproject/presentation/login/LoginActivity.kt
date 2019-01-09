package br.com.multilaser.example.baseproject.presentation.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.multilaser.example.baseproject.R

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = LoginPresenter(this, LoginInjection().interactor)
    }

    override fun loginSuccess() {}

    override fun loginError(error: Throwable) {}

    override fun onDestroy() {
        if (::presenter.isInitialized) presenter.onDestroy()
        super.onDestroy()
    }
}
