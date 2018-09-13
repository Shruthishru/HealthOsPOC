package app.compassites.com.healthosapp.features.medicinedetail

import android.arch.lifecycle.ViewModelProviders
import android.widget.Toast
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.DataManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseActivity
import app.compassites.com.healthosapp.model.Medicine
import kotlinx.android.synthetic.main.activity_medicine_detail.*

class MedicineDetailActivity : BaseActivity() {
    lateinit var medicineViewModel: MedicineDetailViewModel

    override fun initViews() {
        extractBundleData()
        updateViews()
    }

    private fun updateViews() {
        tv_medicine_name.setText("" + medicine.name)
        tv_medicine_form.setText("" + medicine.form)
        tv_medicine_package_form.setText("" + medicine.packageForm)
        tv_medicine_price.setText("" + medicine.price)
        tv_medicine_size.setText("" + medicine.size)
        tv_medicine_manufacturer.setText("" + medicine.manufacturer)

        DataManager.getDataManager(this).putValue(Constants.RECENT_MEDICINE, medicine.name)
    }

    lateinit var medicine: Medicine

    private fun extractBundleData() {

        if (intent != null && intent.extras != null && intent.extras != null && intent.extras.containsKey(Constants.MEDICINE)) {
            medicine = intent.extras.getParcelable<Medicine>(Constants.MEDICINE)
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
