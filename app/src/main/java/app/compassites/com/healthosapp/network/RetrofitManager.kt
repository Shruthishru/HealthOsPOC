package app.compassites.com.healthosapp.network

import app.compassites.com.healthosapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by shruthi on 11/9/18.
 */
class RetrofitManager {

    companion object {
        var retrofit: Retrofit? = null

        fun getRetrofitInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BuildConfig.SERVER_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return retrofit!!
        }

        fun getApiService(): ApiService {
            return getRetrofitInstance().create(ApiService::class.java)
        }
    }

}