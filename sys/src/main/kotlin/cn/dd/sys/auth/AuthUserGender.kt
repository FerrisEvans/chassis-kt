package cn.dd.sys.auth

enum class AuthUserGender(val code: String, val desc: String) {
    /** 部分平台不会返回用户性别，为了方便统一，使用UNKNOWN标记所有未知或不可测的用户性别信息 */
    MALE("1", "男"),
    FEMALE("0", "女"),
    UNKNOWN("-1", "未知"),
    ;

    companion object {
        fun getRealGender(originalGender: String?): AuthUserGender {
            return if (null == originalGender || UNKNOWN.code == originalGender) UNKNOWN
            else if (listOf("m", "男", "1", "male").contains(originalGender.lowercase())) MALE
            else FEMALE
        }

        fun getWechatRealGender(originalGender: String?): AuthUserGender {
            return if (originalGender.isNullOrEmpty() || "0" == originalGender) UNKNOWN else getRealGender(originalGender)
        }
    }
}