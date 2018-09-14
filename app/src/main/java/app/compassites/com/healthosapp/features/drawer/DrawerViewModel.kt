package app.compassites.com.healthosapp.features.drawer

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData

class DrawerViewModel(application: Application) : AndroidViewModel(application) {
    val drawerModel = DrawerModel()
    fun getDrawerItems(): MutableLiveData<List<DrawerItem>> {
        return drawerModel.getAdapterItem()
    }

    fun fetchDrawerItems() {
        drawerModel.initDrawerItems()
    }

}
