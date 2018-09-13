package app.compassites.com.healthosapp.features.login

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.model.AuthTokenRequest
import app.compassites.com.healthosapp.model.AuthTokenResponse
import app.compassites.com.healthosapp.network.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModel {

    val authResponse = MutableLiveData<AuthTokenResponse>()

    fun getAuth(): MutableLiveData<AuthTokenResponse> {

        val request = AuthTokenRequest()
        request.client_id = Constants.CLIENT_ID
        request.grant_type = Constants.GRANT_TYPE
        request.client_secret = Constants.CLIENT_SECRET
        request.scope = Constants.SCOPE
        RetrofitManager.getApiService().authTokenProvider(request)
                .enqueue(object : Callback<AuthTokenResponse> {
                    override fun onFailure(call: Call<AuthTokenResponse>?, error: Throwable?) {
                        Log.i("Error", "Failed " + error)
                    }

                    override fun onResponse(call: Call<AuthTokenResponse>?, response: Response<AuthTokenResponse>?) {
                        Log.e("", "")
                        authResponse.postValue(response?.body())
                    }

                })
        return authResponse
    }

}
