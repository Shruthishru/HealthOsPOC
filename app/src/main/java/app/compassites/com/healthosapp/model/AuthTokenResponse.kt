package app.compassites.com.healthosapp.model

data class AuthTokenRequest(
        var grant_type: String,
        var client_id: String,
        var client_secret: String,
        var scope: String
) {
    constructor() : this("", "", "", "")
}


data class AuthTokenResponse(
        var access_token: String,
        var token_type: String,
        var scope: String,
        var created_at: Int
)