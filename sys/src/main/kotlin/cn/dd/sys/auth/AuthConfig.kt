package cn.dd.sys.auth

data class AuthConfig(
    /**
     * 客户端id：对应各平台的appKey
     */
    val clientId: String,
    /**
     * 客户端Secret：对应各平台的appSecret
     */
    val clientSecret: String,
    /**
     * 登录成功后的回调地址
     */
    val redirectUri: String,
    /**
     * 是否需要申请unionId，目前只针对qq登录
     * 注：qq授权登录时，获取unionId需要单独发送邮件申请权限。如果个人开发者账号中申请了该权限，可以将该值置为true，在获取openId时就会同步获取unionId
     * 参考链接：http://wiki.connect.qq.com/unionid%E4%BB%8B%E7%BB%8D
     */
    val unionId: Boolean?,
    /**
     * 支持自定义授权平台的 scope 内容
     */
    val scopes: List<String>,
    /**
     * 设备ID, 设备唯一标识ID
     */
    val deviceId: String,

)
