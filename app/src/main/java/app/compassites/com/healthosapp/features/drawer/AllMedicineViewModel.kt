package app.compassites.com.healthosapp.features.drawer

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import app.compassites.com.healthosapp.features.home.MedicineModel
import app.compassites.com.healthosapp.model.Medicine

class AllMedicineViewModel(application: Application) : AndroidViewModel(application) {

    val medicineModel = MedicineModel()


    fun getLiveData(): MutableLiveData<List<Medicine>> {
        return medicineModel.getLiveDataForAllMedicine()
    }

    fun getAllMedicinesForPage(pageNumber: Int, pageLimit: Int, auth: String?) {
        medicineModel.fetchMedicinesForPage(pageNumber, pageLimit, auth)
    }

}
