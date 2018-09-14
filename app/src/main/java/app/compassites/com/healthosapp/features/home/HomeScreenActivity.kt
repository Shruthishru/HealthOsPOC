package app.compassites.com.healthosapp.features.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.Menu
import android.view.MenuItem
import android.view.View
import app.compassites.com.healthosapp.Constants
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.base.BaseActivity
import app.compassites.com.healthosapp.features.drawer.AllMedicineFragment
import app.compassites.com.healthosapp.features.drawer.DrawerFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeScreenActivity : BaseActivity(), DrawerLayout.DrawerListener {


    private fun setupToolBar() {
        setSupportActionBar(tb_home)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_drawer_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        tb_home.setNavigationOnClickListener({
            dl_home_landing.openDrawer(GravityCompat.START)
        })
        tb_home.setTitle("Medicine")

        dl_home_landing.addDrawerListener(this)
    }

    override fun onDrawerStateChanged(newState: Int) {

    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

    }

    override fun onDrawerClosed(drawerView: View) {

    }

    override fun onDrawerOpened(drawerView: View) {

    }

    lateinit var viewModel: HomeViewModel

    override fun initViews() {

        setupToolBar()

        initState()

        loadDrawer()

        openRecentSearch()
    }


    private fun initState() {
        viewModel.viewState.observe(this, Observer {
            when (it) {

                HomeViewState.OPEN_MEDICINE_SEARCH -> {
                    openMedicineSearch()
                }

                HomeViewState.OPEN_ALL_MEDICINE -> {
                    openALlMedicines()
                }
                else -> {

                }
            }
        })
    }

    private fun openALlMedicines() {
        setFragment(R.id.fl_home_container, AllMedicineFragment.newInstance(), false, Constants.FRAGMENT_REPLACE)
    }

    private fun openMedicineSearch() {
        setFragment(R.id.fl_home_container, MedicineSearchFragment.newInstance(), false, Constants.FRAGMENT_REPLACE)
    }

    private fun openRecentSearch() {
        setFragment(R.id.fl_home_container, RecentSearchFragment.newInstance(), false, Constants.FRAGMENT_REPLACE)
    }

    private fun loadDrawer() {
        setFragment(R.id.fl_drawer_container, DrawerFragment.newInstance(), false, Constants.FRAGMENT_REPLACE)
    }


    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }


    override fun getLayout(): Int {
        return R.layout.activity_home
    }

    override fun onBackPressed() {

        if (dl_home_landing.isDrawerOpen(GravityCompat.START)) {
            dl_home_landing.closeDrawer(GravityCompat.START)
        } else {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fl_home_container)

            if (currentFragment is MedicineSearchFragment) {
                openRecentSearch()
            } else if (currentFragment is AllMedicineFragment) {
                openRecentSearch()
            } else {
                super.onBackPressed()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                dl_home_landing.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}