package app.compassites.com.healthosapp.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import app.compassites.com.healthosapp.Constants.Companion.FRAGMENT_ADD
import app.compassites.com.healthosapp.Constants.Companion.FRAGMENT_REPLACE

/**
 * Created by shruthi on 11/9/18.
 */
abstract class BaseActivity : AppCompatActivity() {

    fun setFragment(containerId: Int, currentFragment: Fragment,
                    addTobackStack: Boolean, transactionType: Int) {
        val transaction = supportFragmentManager.beginTransaction()

        if (transactionType == FRAGMENT_ADD) {
            transaction.add(containerId, currentFragment, currentFragment.javaClass.simpleName)
        } else if (transactionType == FRAGMENT_REPLACE) {
            transaction.replace(containerId, currentFragment, currentFragment.javaClass.simpleName)
        }
        if (addTobackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commitAllowingStateLoss()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayout())

        initViewModel()

        initViews()
    }

    abstract fun initViews()

    abstract fun initViewModel()

    @LayoutRes
    abstract fun getLayout(): Int
}