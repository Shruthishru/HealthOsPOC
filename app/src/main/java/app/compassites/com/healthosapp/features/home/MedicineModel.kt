package app.compassites.com.healthosapp.features.home

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import app.compassites.com.healthosapp.model.Medicine
import app.compassites.com.healthosapp.model.MedicineDetail
import app.compassites.com.healthosapp.network.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MedicineModel {

    val medicineLiveData = MutableLiveData<List<Medicine>>()
    val medicineDetail = MutableLiveData<MedicineDetail>()

    fun getMedicines(auth: String?, query: String) {

        RetrofitManager.getApiService().getAllMedicines(query, auth)
                .enqueue(object : Callback<List<Medicine>> {
                    override fun onFailure(call: Call<List<Medicine>>?, t: Throwable?) {
                        Log.e("error", "ERROR :" + t)
                    }

                    override fun onResponse(call: Call<List<Medicine>>,
                                            response: Response<List<Medicine>>) {
                        Log.i("response", "List : " + response.body())
                        medicineLiveData.postValue(response.body())
                    }

                })
    }

    fun getMedicineDetails(medicineID: String, auth: String?) {
        RetrofitManager.getApiService().getMedicineDetail(medicineID, auth)
                .enqueue(object : Callback<MedicineDetail> {
                    override fun onFailure(call: Call<MedicineDetail>?, t: Throwable?) {
                        Log.e("error", "ERROR :" + t)
                    }

                    override fun onResponse(call: Call<MedicineDetail>?, response: Response<MedicineDetail>?) {
                        Log.i("response", "List : " + response!!.body())
                        medicineDetail.postValue(response.body())
                    }


                })

    }


}
