package app.compassites.com.healthosapp.model

import com.google.gson.annotations.SerializedName

/**
 * Created by shruthi on 14/9/18.
 */

data class MedicineDetail(

        @SerializedName("name")
        val name: String,

        @SerializedName("unit_price")
        val unitPrice: Float,

        @SerializedName("pregnancy")
        val pregnancy: Pregnancy,


        @SerializedName("medicine__id")
        val medicine_Id: String,

        @SerializedName("lactation")
        val lactation: Pregnancy,

        @SerializedName("package_form")
        val packageForm: String,


        @SerializedName("product_group_name")
        val productGroupName: String,

        @SerializedName("price")
        val price: Float,

        @SerializedName("standard_units")
        val standardUnits: Int,

        @SerializedName("form")
        val form: String,

        @SerializedName("size")
        val size: String,


        @SerializedName("per_unit")
        val perUnit: Int,

        @SerializedName("manufacturer")
        val manufacturer: String,

        @SerializedName("mrp")
        val mrp: Float,

        @SerializedName("constituents")
        val constituents: List<Constituents>,

        @SerializedName("components")
        val components: List<Components>,

        @SerializedName("schedule")
        val schedule: MedicineSchedule

) {
}

data class Pregnancy(

        @SerializedName("category")
        val category: String,


        @SerializedName("label")
        val label: String,


        @SerializedName("description")
        val description: String


) {

}

data class MedicineSchedule(

        @SerializedName("category")
        val category: String,


        @SerializedName("label")
        val label: String


) {

}

data class Constituents(

        @SerializedName("name")
        val name: String,


        @SerializedName("strength")
        val strength: String

) {

}

data class Components(

        @SerializedName("name")
        val name: String,


        @SerializedName("pregnancy_category")
        val pregnancyCategory: String,


        @SerializedName("lactation_category")
        val lactationCategory: String,

        @SerializedName("instructions")
        val instructions: String,

        @SerializedName("faqs")
        val faqs: String,

        @SerializedName("side_effects")
        val sideEffects: String,

        @SerializedName("how_it_works")
        val howItWorks: String,

        @SerializedName("therapeutic_class")
        val therapeuticClass: String,


        @SerializedName("used_for")
        val usedFor: String,


        @SerializedName("strength")
        val strength: String,

        @SerializedName("schedule")
        val schedule: String,


        @SerializedName("alcohol_interaction_description")
        val alcoholInteractionDescription: String,


        @SerializedName("alcohol_nteraction")
        val alcoholNteraction: String


)