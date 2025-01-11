package cn.dd.sys.rbac

//@Table("sys_user")
data class User(
    val username: String,
    val password: String,
    val nickname: String,
    val phone: String?,
    val email: String?,
    val enabled: Boolean = true,
)
