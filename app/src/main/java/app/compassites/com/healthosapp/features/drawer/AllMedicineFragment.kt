package app.compassites.com.healthosapp.features.drawer

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_all_medicine.*

class AllMedicineFragment : BaseFragment() {

    val allmedicineAdapter = AllMedicineAdapter()

    override fun initViews() {
        rvAllMedicines.layoutManager = LinearLayoutManager(activity)
        rvAllMedicines.adapter = allmedicineAdapter
        rvAllMedicines.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

        })
    }

    override fun initViewModel() {
    }

    override fun getLayout(): Int {
        return R.layout.fragment_all_medicine
    }

}
