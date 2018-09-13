package app.compassites.com.healthosapp.features.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v4.app.Fragment
import android.util.Log
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.DataManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseFragment
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.api.GoogleApiClient
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : BaseFragment() {


    private var mGoogleApiClient: GoogleApiClient? = null

    private val RC_SIGN_IN: Int = 1001

    lateinit var viewModel: LoginViewModel

    lateinit var onBoardViewModel: OnBoardViewModel

    override fun initViews() {
        Log.e("", "Login Called")

        doGoogleSignIn()
        btn_sign_in.setOnClickListener {
            val intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
            startActivityForResult(intent, RC_SIGN_IN)
        }
    }

    private fun doGoogleSignIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()


        if (mGoogleApiClient == null) {
            mGoogleApiClient = GoogleApiClient.Builder(activity!!)
                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                    .build()
        }
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        onBoardViewModel = ViewModelProviders.of(activity!!).get(OnBoardViewModel::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_login
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            requestAuthToken(result)
        }
    }

    private fun requestAuthToken(result: GoogleSignInResult?) {
        if (result!!.isSuccess()) {
            val acct = result.getSignInAccount()
            viewModel.getAuthTokenService().observe(this, Observer {
                Log.i("google account", "account" + acct)
                DataManager.getDataManager(activity!!).putValue(Constants.AUTHORIZATION_KEY,
                        Constants.AUTHORIZATION_VALUE + it?.access_token)
                navigateToHome()
            })
            Log.i("google account", "account" + acct)
        }
    }

    private fun navigateToHome() {
        onBoardViewModel.viewState.postValue(OnBoardViewState.OPEN_HOME)
    }

    companion object {
        fun newInstance(): Fragment {
            val fragment = LoginFragment()
            return fragment
        }
    }
}
