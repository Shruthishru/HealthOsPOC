package app.compassites.com.healthosapp.features.search

import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.model.Medicine
import kotlinx.android.synthetic.main.fragment_search_result.*
import org.parceler.Parcels
import retrofit2.Response

class SearchResultFragment : Fragment() {

    /*private var adapter: MedicineListAdapter = MedicineListAdapter(this)
    private var response: List<Medicine>? = null

    companion object {
        fun newInstance(medicineList: Response<List<Medicine>>?): Fragment {
            val fragment = SearchResultFragment()
            val bundle = Bundle()
            bundle.putParcelable(Medicine::class.qualifiedName, Parcels.wrap(medicineList))
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_search_result, container, false)
    }

    private fun extractBundle() {
        val bundle = arguments
        if (bundle != null) {
            if (bundle.containsKey(Medicine::class.java!!.getName())) {
                response = Parcels.unwrap<List<Medicine>>(bundle.getParcelable<Parcelable>
                (Medicine::class.java!!.getName()))
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        extractBundle()
        rv_list.layoutManager = LinearLayoutManager(context)
        rv_list.adapter = adapter
//        adapter.updateAdapterData(response!!)
    }*/
}
