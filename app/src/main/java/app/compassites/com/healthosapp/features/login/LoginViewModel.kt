package app.compassites.com.healthosapp.features.login

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import app.compassites.com.healthosapp.base.BaseViewModel
import app.compassites.com.healthosapp.model.AuthTokenResponse

class LoginViewModel(application: Application) : BaseViewModel(application) {

    val loginModel = LoginModel()

    fun getAuthTokenService(): MutableLiveData<AuthTokenResponse> {
        return loginModel.getAuth()
    }

}
