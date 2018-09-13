package app.compassites.com.healthosapp.features.home

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import app.compassites.com.healthosapp.base.BaseViewModel
import app.compassites.com.healthosapp.model.Medicine

class MedicineSearchViewModel(application: Application) : BaseViewModel(application) {
    val medicineModel = MedicineModel()

    fun getMedicineForQuery(auth: String?, query: String) {
        medicineModel.getMedicines(auth, query)
    }

    fun getLiveData(): MutableLiveData<List<Medicine>> {
        return medicineModel.medicineLiveData
    }

}
