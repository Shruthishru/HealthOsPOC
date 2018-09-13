package app.compassites.com.healthosapp

/**
 * Created by shruthi on 11/9/18.
 */
interface Constants {
    companion object {
        val FRAGMENT_ADD: Int = 1
        val FRAGMENT_REPLACE: Int = 2
        val CLIENT_ID: String = "df1fda2c3de4d1bb4f5158eca4f3d1e880f80414059d3144616d6ea5ec5c957e"
        val GRANT_TYPE: String = "client_credentials"
        val CLIENT_SECRET: String = "5c917337e563b2857ca2ddbf5ae6e1668c9b3d34bdeab96edf2c8dd40fd3e9df"
        val SCOPE: String = "public read write"
        const val AUTHORIZATION_KEY: String = "Authorization"
        const val AUTHORIZATION_VALUE: String = "BEARER "
        const val RECENT_MEDICINE: String = "recent_medicine_key"
        const val MEDICINE: String = "med_key"
    }

}