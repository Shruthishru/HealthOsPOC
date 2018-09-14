package app.compassites.com.healthosapp.features.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.widget.Toast
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.DataManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseActivity
import app.compassites.com.healthosapp.features.home.HomeScreenActivity
import app.compassites.com.healthosapp.features.login.OnBoardViewState.OPEN_HOME
import app.compassites.com.healthosapp.features.login.OnBoardViewState.OPEN_LOGIN
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

class OnBoardActivity : BaseActivity() {

    override fun initViews() {
        listenState()
        Fabric.with(this, Crashlytics())
        openSplashScreen()
    }

    private fun listenState() {
        viewModel.viewState.observe(this, Observer {
            when (it) {

                OPEN_LOGIN -> {
                    openLoginScreen()
                }
                OPEN_HOME -> {
                    openHomeScreen()
                }
                else -> {
                    Toast.makeText(this, "invalid state", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun openHomeScreen() {
        val authToken = DataManager.getDataManager(this).getString(Constants.AUTHORIZATION_KEY)
        if (authToken.isNullOrEmpty()) {
            openLoginScreen()
        } else {
            val intent = Intent(this, HomeScreenActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    private fun openLoginScreen() {
        setFragment(R.id.fl_login_container, LoginFragment.newInstance(), false,
                Constants.FRAGMENT_REPLACE)
    }

    private fun openSplashScreen() {
        setFragment(R.id.fl_login_container, SplashFragment.newInstance(), false,
                Constants.FRAGMENT_REPLACE)
    }

    lateinit var viewModel: OnBoardViewModel

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(OnBoardViewModel::class.java)
    }


    override fun getLayout(): Int {
        return R.layout.activity_login
    }

}