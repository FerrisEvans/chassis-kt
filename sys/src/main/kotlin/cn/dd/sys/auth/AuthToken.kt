package cn.dd.sys.auth

data class AuthToken(
    val accessToken: String,
    val expireIn: Int,
    val refreshToken: String,
    val refreshTokenExpireIn: Int,
    val uid: String? = null,
    val openId: String? = null,
    val accessCode: String? = null,
)
