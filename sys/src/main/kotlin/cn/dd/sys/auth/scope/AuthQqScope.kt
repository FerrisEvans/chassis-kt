package cn.dd.sys.auth.scope

enum class AuthQqScope (val scope: String, val desc: String, val default: Boolean): AuthScope {
    GET_USER_INFO("get_user_info", "获取登录用户的昵称、头像、性别", true),
    /**
     * 以下 scope 需要申请：http://wiki.connect.qq.com/openapi%e6%9d%83%e9%99%90%e7%94%b3%e8%af%b7
     */
    GET_VIP_INFO("get_vip_info", "获取QQ会员的基本信息", false),
    GET_VIP_RICH_INFO("get_vip_rich_info", "获取QQ会员的高级信息", false),
    LIST_ALBUM("list_album", "获取用户QQ空间相册列表", false),
    UPLOAD_PIC("upload_pic", "上传一张照片到QQ空间相册", false),
    ADD_ALBUM("add_album", "在用户的空间相册里，创建一个新的个人相册", false),
    LIST_PHOTO("list_photo", "获取用户QQ空间相册中的照片列表", false),
    ;

    override fun scope(): String = this.scope

    override fun default(): Boolean = this.default
}