package app.compassites.com.healthosapp.features.drawer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.DataManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_all_medicine.*

class AllMedicineFragment : BaseFragment() {

    val allmedicineAdapter = AllMedicineAdapter()
    lateinit var viewModel: AllMedicineViewModel

    val pageLimit = 10
    val pagNumber = 1

    override fun initViews() {
        initRecycler()
        initLiveData()
        getLiveDataForPage(1)
    }

    private fun getLiveDataForPage(pageNumber: Int) {
        val auth = DataManager.getDataManager(activity).getString(Constants.AUTHORIZATION_KEY)
        viewModel.getAllMedicinesForPage(pageNumber, pageLimit, auth)
    }

    private fun initLiveData() {
        viewModel.getLiveData().observe(this, Observer {
            allmedicineAdapter.updateItems(ArrayList(it))
        })
    }

    private fun initRecycler() {
        rvAllMedicines.layoutManager = LinearLayoutManager(activity)
        rvAllMedicines.adapter = allmedicineAdapter
        rvAllMedicines.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                Log.e("", "")

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                Log.e("", "")
            }

        })
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(activity!!).get(AllMedicineViewModel::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_all_medicine
    }


    companion object {
        fun newInstance(): Fragment {
            val fragment = AllMedicineFragment()
            return fragment
        }
    }
}
