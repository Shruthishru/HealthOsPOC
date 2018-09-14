package app.compassites.com.healthosapp.features.medicinedetail

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import app.compassites.com.healthosapp.base.BaseViewModel
import app.compassites.com.healthosapp.features.home.MedicineModel
import app.compassites.com.healthosapp.model.MedicineDetail

class MedicineDetailViewModel(application: Application) : BaseViewModel(application) {
    val medicineModel = MedicineModel()

    fun getMedicineDetail(medicineID: String, auth: String?) {
        medicineModel.getMedicineDetails(medicineID, auth)
    }

    fun getLiveData(): MutableLiveData<MedicineDetail> {
        return medicineModel.medicineDetail
    }

}
