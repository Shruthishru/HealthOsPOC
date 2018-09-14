package app.compassites.com.healthosapp.features.home

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.view.animation.AnimationUtils
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.DataManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_recent_search.*
import java.util.*


class RecentSearchFragment : BaseFragment() {

    lateinit var viewModel: RecentSearchViewModel

    lateinit var homeViewModel: HomeViewModel

    override fun initViews() {
        btn_search_medicine.setOnClickListener {
            homeViewModel.viewState.postValue(HomeViewState.OPEN_MEDICINE_SEARCH)
        }
        iv_main_logo.animation = AnimationUtils.loadAnimation(activity, R.anim.anim_zoom_in_out)
        iv_main_logo.animation.start()
        updateRecentMedicine()
        updateCurrentDateTime()
    }

    private fun updateCurrentDateTime() {
        val currentTime = Calendar.getInstance().time
        tv_time.setText(currentTime.toString())
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
