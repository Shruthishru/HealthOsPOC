package app.compassites.com.healthosapp.features.home

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import app.compassites.com.healthosapp.base.BaseViewModel

class HomeViewModel(application: Application) : BaseViewModel(application) {
    val viewState = MutableLiveData<HomeViewState>()

}
