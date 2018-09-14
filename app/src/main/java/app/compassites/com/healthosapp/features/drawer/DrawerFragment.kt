package app.compassites.com.healthosapp.features.drawer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseFragment
import app.compassites.com.healthosapp.features.home.HomeViewModel
import app.compassites.com.healthosapp.features.home.HomeViewState
import kotlinx.android.synthetic.main.fragment_drawer.*

class DrawerFragment : BaseFragment(), DraweritemCallBack {

    override fun onItemClick(item: DrawerItem) {
        if (item.type == 1) {
            homeViewModel.viewState.postValue(HomeViewState.OPEN_ALL_MEDICINE)
        } else if (item.type == 2) {
            homeViewModel.viewState.postValue(HomeViewState.OPEN_ALL_EXERCISE)
        }
    }

    companion object {
        fun newInstance(): Fragment {
            val fragment = DrawerFragment()
            return fragment
        }
    }

    lateinit var viewModel: DrawerViewModel
    lateinit var homeViewModel: HomeViewModel

    var drawerAdapter = DrawerItemAdapter(this)

    override fun initViews() {
        rv_drawer_items.layoutManager = LinearLayoutManager(context)
        rv_drawer_items.adapter = drawerAdapter
        val itemDecoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        rv_drawer_items.addItemDecoration(itemDecoration)


        getLiveDataForDrawer()
        fetchDrawerItems()
    }

    private fun fetchDrawerItems() {
        viewModel.fetchDrawerItems()
    }

    private fun getLiveDataForDrawer() {
        viewModel.getDrawerItems().observe(this, Observer {
            drawerAdapter.updateItems(ArrayList(it))
        })
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(activity!!).get(DrawerViewModel::class.java)
        homeViewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_drawer
    }

}
