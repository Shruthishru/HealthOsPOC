package app.compassites.com.healthosapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by shruthi on 11/9/18.
 */

@Parcelize
data class Medicine(
        var name: String,
        var form: String,
        var standardUnits: Int,
        var packageForm: String,
        var price: Float,
        var size: String,
        var manufacturer: String,
        var constituents: List<Constituent>,
        var schedule: Schedule
) : Parcelable

@Parcelize
data class Constituent(
        var name: String,
        var strength: String
) : Parcelable

@Parcelize
data class Schedule(
        var category: String,
        var label: String
) : Parcelable