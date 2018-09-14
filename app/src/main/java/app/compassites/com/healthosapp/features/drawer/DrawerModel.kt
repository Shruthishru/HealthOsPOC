package app.compassites.com.healthosapp.features.drawer

import android.arch.lifecycle.MutableLiveData

class DrawerModel {
    val adapterLiveData = MutableLiveData<List<DrawerItem>>()
    fun getAdapterItem(): MutableLiveData<List<DrawerItem>> {
        return adapterLiveData
    }

    fun initDrawerItems() {
        val items = ArrayList<DrawerItem>()
        items.add(DrawerItem(1,"All Medicines"))
        items.add(DrawerItem(1,"All Medicines"))
        items.add(DrawerItem(1,"All Medicines"))
        items.add(DrawerItem(1,"All Medicines"))
        adapterLiveData.postValue(items)
    }

}
