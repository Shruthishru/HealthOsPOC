package app.compassites.com.healthosapp.features.login

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import app.compassites.com.healthosapp.base.BaseViewModel

class OnBoardViewModel(application: Application) : BaseViewModel(application) {

    var viewState = MutableLiveData<OnBoardViewState>()

}
