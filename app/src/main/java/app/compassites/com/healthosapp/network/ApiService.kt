package app.compassites.com.healthosapp.network

import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.model.AuthTokenRequest
import app.compassites.com.healthosapp.model.AuthTokenResponse
import app.compassites.com.healthosapp.model.Medicine
import app.compassites.com.healthosapp.model.MedicineDetail
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by shruthi on 11/9/18.
 */
interface ApiService {

    @POST("oauth/token.json")
    fun authTokenProvider(@Body authToken: AuthTokenRequest): Call<AuthTokenResponse>

    @GET("autocomplete/medicines/brands/{query}")
    fun getAllMedicines(@Path("query") query: String,
                        @Header(Constants.AUTHORIZATION_KEY)
                        authToken: String?): Call<List<Medicine>>

    @GET("medicines/brands/{medicine_id}")
    fun getMedicineDetail(@Path("medicine_id") medicineID: String,
                          @Header(Constants.AUTHORIZATION_KEY)
                          auth: String?): Call<MedicineDetail>

    @GET("medicines/brands")
    fun getMedicines(
            @QueryMap pagingMap: Map<String, String>,
            @Header(Constants.AUTHORIZATION_KEY)
            auth: String?): Call<List<Medicine>>

}