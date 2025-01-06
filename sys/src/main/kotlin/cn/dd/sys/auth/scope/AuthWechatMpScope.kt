package cn.dd.sys.auth.scope

/**
 * 微信公众平台 OAuth 授权范围
 */
enum class AuthWechatMpScope(val scope: String, val desc: String, val default: Boolean) : AuthScope {

    SNSAPI_USERINFO(
        "snsapi_userinfo",
        "弹出授权页面，可通过openid拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息",
        true
    ),
    SNSAPI_BASE("snsapi_base", "不弹出授权页面，直接跳转，只能获取用户openid", false),
    ;

    override fun scope(): String = this.scope

    override fun default(): Boolean = this.default
}