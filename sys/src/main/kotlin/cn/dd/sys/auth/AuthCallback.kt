package cn.dd.sys.auth

data class AuthCallback(
    /**
     * 访问AuthorizeUrl后回调时带的参数code
     */
    val code: String? = null,
    /**
     * 访问AuthorizeUrl后回调时带的参数auth_code，该参数目前只使用于支付宝登录
     */
    val auth_code: String? = null,
    /**
     * 访问AuthorizeUrl后回调时带的参数state，用于和请求AuthorizeUrl前的state比较，防止CSRF攻击
     */
    val state: String? = null,
) {
    fun code(): String {
        return if (code.isNullOrBlank()) auth_code.toString() else code
    }
}
