package cn.dd.sys.auth.source

import cn.dd.sys.auth.req.*

enum class AuthDefaultSource : AuthSource {
    /**
     * Github
     */
    GITHUB {
        override fun authorize(): String {
            return "https://github.com/login/oauth/authorize"
        }

        override fun accessToken(): String {
            return "https://github.com/login/oauth/access_token"
        }

        override fun userInfo(): String {
            return "https://api.github.com/user"
        }

        override fun getTargetClass(): Class<out AuthDefaultRequest?> {
            return AuthGithubRequest::class.java
        }
    },

    /**
     * gitee
     */
    GITEE {
        override fun authorize(): String {
            return "https://gitee.com/oauth/authorize"
        }

        override fun accessToken(): String {
            return "https://gitee.com/oauth/token"
        }

        override fun userInfo(): String {
            return "https://gitee.com/api/v5/user"
        }

        override fun getTargetClass(): Class<out AuthDefaultRequest?> {
            return AuthGiteeRequest::class.java
        }
    },

    /**
     * csdn
     */
    CSDN {
        override fun authorize(): String {
            return "https://api.csdn.net/oauth2/authorize"
        }

        override fun accessToken(): String {
            return "https://api.csdn.net/oauth2/access_token"
        }

        override fun userInfo(): String {
            return "https://api.csdn.net/user/getinfo"
        }

        override fun getTargetClass(): Class<out AuthDefaultRequest?> {
            return AuthCsdnRequest::class.java
        }
    },

    /**
     * 阿里云
     */
    ALIYUN {
        override fun authorize(): String {
            return "https://signin.aliyun.com/oauth2/v1/auth"
        }

        override fun accessToken(): String {
            return "https://oauth.aliyun.com/v1/token"
        }

        override fun userInfo(): String {
            return "https://oauth.aliyun.com/v1/userinfo"
        }

        override fun refresh(): String {
            return "https://oauth.aliyun.com/v1/token"
        }

        override fun getTargetClass(): Class<out AuthDefaultRequest?> {
            return AuthAliyunRequest::class.java
        }
    },

    /**
     * 支付宝
     */
    ALIPAY {
        override fun authorize(): String {
            return "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm"
        }

        override fun accessToken(): String {
            return "https://openapi.alipay.com/gateway.do"
        }

        override fun userInfo(): String {
            return "https://openapi.alipay.com/gateway.do"
        }

        override fun getTargetClass(): Class<out AuthDefaultRequest?> {
            return AuthAlipayRequest::class.java
        }
    },

    /**
     * QQ
     */
    QQ {
        override fun authorize(): String {
            return "https://graph.qq.com/oauth2.0/authorize"
        }

        override fun accessToken(): String {
            return "https://graph.qq.com/oauth2.0/token"
        }

        override fun userInfo(): String {
            return "https://graph.qq.com/user/get_user_info"
        }

        override fun refresh(): String {
            return "https://graph.qq.com/oauth2.0/token"
        }

        override fun getTargetClass(): Class<out AuthDefaultRequest?> {
            return AuthQqRequest::class.java
        }
    },

    /**
     * 微信开放平台
     */
    WECHAT_OPEN {
        override fun authorize(): String {
            return "https://open.weixin.qq.com/connect/qrconnect"
        }

        override fun accessToken(): String {
            return "https://api.weixin.qq.com/sns/oauth2/access_token"
        }

        override fun userInfo(): String {
            return "https://api.weixin.qq.com/sns/userinfo"
        }

        override fun refresh(): String {
            return "https://api.weixin.qq.com/sns/oauth2/refresh_token"
        }

        override fun getTargetClass(): Class<out AuthDefaultRequest?> {
            return AuthWeChatOpenRequest::class.java
        }
    },

    /**
     * 抖音
     */
    DOUYIN {
        override fun authorize(): String {
            return "https://open.douyin.com/platform/oauth/connect"
        }

        override fun accessToken(): String {
            return "https://open.douyin.com/oauth/access_token/"
        }

        override fun userInfo(): String {
            return "https://open.douyin.com/oauth/userinfo/"
        }

        override fun refresh(): String {
            return "https://open.douyin.com/oauth/refresh_token/"
        }

        override fun getTargetClass(): Class<out AuthDefaultRequest?> {
            return AuthDouyinRequest::class.java
        }
    },

    /**
     * 百度
     */
    BAIDU {
        override fun authorize(): String {
            return "https://openapi.baidu.com/oauth/2.0/authorize"
        }

        override fun accessToken(): String {
            return "https://openapi.baidu.com/oauth/2.0/token"
        }

        override fun userInfo(): String {
            return "https://openapi.baidu.com/rest/2.0/passport/users/getInfo"
        }

        override fun revoke(): String {
            return "https://openapi.baidu.com/rest/2.0/passport/auth/revokeAuthorization"
        }

        override fun refresh(): String {
            return "https://openapi.baidu.com/oauth/2.0/token"
        }

        override fun getTargetClass(): Class<out AuthDefaultRequest?> {
            return AuthBaiduRequest::class.java
        }
    },
    ;
}