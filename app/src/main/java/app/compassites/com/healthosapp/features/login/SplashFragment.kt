package app.compassites.com.healthosapp.features.login

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.util.Log
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.DataManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseFragment


class SplashFragment : BaseFragment() {

    lateinit var viewModel: SplashViewModel

    lateinit var onBoardViewModel: OnBoardViewModel

    override fun initViews() {
        Log.e("", "Splash Called")
        val auth = DataManager.getDataManager(activity).getString(Constants.AUTHORIZATION_KEY)
        if (auth.isNullOrEmpty()) {
            onBoardViewModel.viewState.postValue(OnBoardViewState.OPEN_LOGIN)
        } else {
            onBoardViewModel.viewState.postValue(OnBoardViewState.OPEN_HOME)
        }
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        onBoardViewModel = ViewModelProviders.of(activity!!).get(OnBoardViewModel::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_splash
    }

    companion object {
        fun newInstance(): Fragment {
            val fragment = SplashFragment()
            return fragment
        }
    }
}
