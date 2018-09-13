package app.compassites.com.healthosapp.features.home

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.DataManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_recent_search.*


class RecentSearchFragment : BaseFragment() {

    lateinit var viewModel: RecentSearchViewModel

    lateinit var homeViewModel: HomeViewModel

    override fun initViews() {
        btn_search_medicine.setOnClickListener {
            homeViewModel.viewState.postValue(HomeViewState.OPEN_MEDICINE_SEARCH)
        }

        updateRecentMedicine()
    }

    private fun updateRecentMedicine() {
        val recentMedicine = DataManager.getDataManager(activity!!).getString(Constants.RECENT_MEDICINE)
        tv_recent_search.text = if (recentMedicine.isNullOrEmpty()) {
            "No Recent"
        } else {
            recentMedicine
        }
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(RecentSearchViewModel::class.java)
        homeViewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_recent_search
    }

    companion object {
        fun newInstance(): Fragment {
            val fragment = RecentSearchFragment()
            return fragment
        }
    }
}
