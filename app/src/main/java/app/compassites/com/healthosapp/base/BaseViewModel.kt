package app.compassites.com.healthosapp.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

/**
 * Created by shruthi on 12/9/18.
 */
open class BaseViewModel constructor(application: Application) : AndroidViewModel(application) {

    private val context: Application = application


}