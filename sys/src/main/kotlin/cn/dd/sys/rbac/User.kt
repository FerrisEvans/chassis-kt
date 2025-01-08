package cn.dd.sys.rbac

data class User(
    val username: String,
    val password: String,
    val nickname: String,
    val phone: String?,
    val email: String?,
    val enabled: Boolean = true,
)
