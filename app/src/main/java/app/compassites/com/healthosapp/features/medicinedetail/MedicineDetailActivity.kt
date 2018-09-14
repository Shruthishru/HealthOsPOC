package app.compassites.com.healthosapp.features.medicinedetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.widget.Toast
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.DataManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_medicine_detail.*

class MedicineDetailActivity : BaseActivity() {
    lateinit var medicineViewModel: MedicineDetailViewModel

    override fun initViews() {
        extractBundleData()

        getMedicineDetails()

        updateViews()
    }

    private fun getMedicineDetails() {
        val auth = DataManager.getDataManager(this).getString(Constants.AUTHORIZATION_KEY)
        medicineViewModel.getMedicineDetail(medicineID, auth)
    }

    private fun updateViews() {
        medicineViewModel.getLiveData().observe(this, Observer {
            tv_medicine_name.setText("" + it?.name)
            tv_medicine_form.setText("" + it?.form)
            tv_medicine_unit.setText(""+it?.standardUnits)
            tv_medicine_package_form.setText("" + it?.packageForm)
            tv_medicine_price.setText("" + it?.price)
            tv_medicine_size.setText("" + it?.size)
            tv_medicine_manufacturer.setText("" + it?.manufacturer)
            tv_unit_price.setText("" + it?.unitPrice)
            tv_group_name.setText("" + it?.productGroupName)
            tv_mrp.setText("" + it?.mrp)
            tv_per_unit.setText("" + it?.perUnit)

            DataManager.getDataManager(this).putValue(Constants.RECENT_MEDICINE, it?.name!!)
        })

    }

    lateinit var medicineID: String

    private fun extractBundleData() {

        if (intent != null && intent.extras != null && intent.extras.containsKey(Constants.MEDICINE)) {
            medicineID = intent.extras.getString(Constants.MEDICINE)
        } else {
            Toast.makeText(this, "unable to get Medicine", Toast.LENGTH_SHORT).show()
            this.finish()
        }
    }

    override fun initViewModel() {
        medicineViewModel = ViewModelProviders.of(this).get(MedicineDetailViewModel::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.activity_medicine_detail
    }

}
