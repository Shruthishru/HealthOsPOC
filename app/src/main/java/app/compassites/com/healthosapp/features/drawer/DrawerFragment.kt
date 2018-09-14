package app.compassites.com.healthosapp.features.drawer

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_drawer.*

class DrawerFragment : BaseFragment() {

    lateinit var viewModel: DrawerViewModel
    var drawerAdapter = DrawerItemAdapter()
    override fun initViews() {
        rv_drawer_items.layoutManager = LinearLayoutManager(context)
        rv_drawer_items.adapter = drawerAdapter
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(activity!!).get(DrawerViewModel::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_drawer
    }

}
