package app.compassites.com.healthosapp.features.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseActivity
import app.compassites.com.healthosapp.features.home.HomeViewState.OPEN_MEDICINE_SEARCH

class HomeScreenActivity : BaseActivity() {

    lateinit var viewModel: HomeViewModel

    override fun initViews() {
        initState()

        openRecentSearch()
    }

    private fun initState() {
        viewModel.viewState.observe(this, Observer {
            when (it) {

                OPEN_MEDICINE_SEARCH -> {
                    openMedicineSearch()
                }
                else -> {

                }
            }
        })
    }

    private fun openMedicineSearch() {
        setFragment(R.id.fl_home_container, MedicineSearchFragment.newInstance(), false, Constants.FRAGMENT_REPLACE)
    }

    private fun openRecentSearch() {
        setFragment(R.id.fl_home_container, RecentSearchFragment.newInstance(), false, Constants.FRAGMENT_REPLACE)
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.activity_home
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fl_home_container)
        if (currentFragment is MedicineSearchFragment) {
            openRecentSearch()
        } else {
            super.onBackPressed()
        }
    }

}
