package app.compassites.com.healthosapp.features.search

import android.support.v4.app.Fragment

class SearchFragment : Fragment() {

}

/*
, SearchView.OnQueryTextListener {

    private var adapter: MedicineListAdapter = MedicineListAdapter()

    override fun onQueryTextSubmit(query: String): Boolean {
        getAllMedicines(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        generateAuthToken()
        sv_search.setOnQueryTextListener(this)

    }

    private fun initListeners() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL
                , false)
        rv_medicine_list.layoutManager = layoutManager
        rv_medicine_list.adapter = adapter
    }

    private fun generateAuthToken() {
        val request = AuthTokenRequest()
        request.client_id = Constants.CLIENT_ID
        request.grant_type = Constants.GRANT_TYPE
        request.client_secret = Constants.CLIENT_SECRET
        request.scope = Constants.SCOPE
        RetrofitManager.getApiService().authTokenProvider(request)
                .enqueue(object : Callback<AuthTokenResponse> {
                    override fun onFailure(call: Call<AuthTokenResponse>?, error: Throwable?) {
                        Log.i("Error", "Failed " + error)
                    }

                    override fun onResponse(call: Call<AuthTokenResponse>?, response: Response<AuthTokenResponse>?) {
                        if (response != null) {
                            DataManager.getDataManager(context).putValue(Constants.AUTHORIZATION_KEY,
                                    Constants.AUTHORIZATION_VALUE + response.body()!!.access_token)
                        }
                    }

                })
    }

    private fun getAllMedicines(query: String) {
        val auth_token = DataManager.getDataManager(context).getString(Constants.AUTHORIZATION_KEY)
        RetrofitManager.getApiService().getAllMedicines(query, auth_token)
                .enqueue(object : Callback<List<Medicine>> {
                    override fun onFailure(call: Call<List<Medicine>>?, t: Throwable?) {
                        Log.e("error", "ERROR :" + t)
                    }

                    override fun onResponse(call: Call<List<Medicine>>,
                                            response: Response<List<Medicine>>) {
                        Log.i("response", "List : " + response.body())
                        adapter.updateAdapterData(response.body()!!)
//                        setFragment(R.id.fl_container, SearchResultFragment.newInstance(response), false, Constants.FRAGMENT_REPLACE)
                    }

                })
    }
}



*/