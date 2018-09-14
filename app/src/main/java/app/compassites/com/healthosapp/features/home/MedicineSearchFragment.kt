package app.compassites.com.healthosapp.features.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.Constants.Companion.MEDICINE
import app.compassites.com.healthosapp.DataManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseFragment
import app.compassites.com.healthosapp.features.medicinedetail.MedicineDetailActivity
import app.compassites.com.healthosapp.features.search.MedicineAdapterClick
import app.compassites.com.healthosapp.features.search.MedicineListAdapter
import app.compassites.com.healthosapp.model.Medicine
import kotlinx.android.synthetic.main.fragment_medicine_search.*


class MedicineSearchFragment : BaseFragment(), TextWatcher, MedicineAdapterClick {

    override fun onItemClick(medicine: Medicine) {
        Log.e("", "item click")
        val intent = Intent(activity!!, MedicineDetailActivity::class.java)
        intent.putExtra(MEDICINE, medicine.medicine_id)
        startActivity(intent)
    }

    override fun afterTextChanged(p0: Editable?) {

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
        val auth = DataManager.getDataManager(activity!!).getString(Constants.AUTHORIZATION_KEY)
        if (!text.isNullOrEmpty())
            viewModel.getMedicineForQuery(auth, text.toString())
    }

    lateinit var viewModel: MedicineSearchViewModel

    lateinit var homeViewModel: HomeViewModel

    val medicineListAdapter = MedicineListAdapter(this)

    override fun initViews() {
        rv_medicine_list.layoutManager = LinearLayoutManager(activity)
        rv_medicine_list.adapter = medicineListAdapter

        et_search_medicine.addTextChangedListener(this)

        viewModel.getLiveData().observe(this, Observer {
            medicineListAdapter.updateAdapterData(ArrayList(it))
        })
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MedicineSearchViewModel::class.java)
        homeViewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_medicine_search
    }


    companion object {
        fun newInstance(): Fragment {
            val fragment = MedicineSearchFragment()
            return fragment
        }
    }
}
