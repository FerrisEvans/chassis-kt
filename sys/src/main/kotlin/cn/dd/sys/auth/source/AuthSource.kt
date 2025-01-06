package cn.dd.sys.auth.source

import cn.dd.sys.auth.AuthResponseStatus
import cn.dd.sys.auth.AuthException
import cn.dd.sys.auth.req.AuthDefaultRequest

/**
 * 获取相关平台对应api的uri
 */
interface AuthSource {
    /**
     * 授权
     */
    fun authorize(): String

    /**
     * 获取accessToken
     */
    fun accessToken(): String

    /**
     * 获取用户信息
     */
    fun userInfo(): String

    /**
     * 取消授权
     */
    fun revoke(): String = throw AuthException(AuthResponseStatus.UNSUPPORTED)


    /**
     * 刷新授权
     */
    fun refresh(): String = throw AuthException(AuthResponseStatus.UNSUPPORTED)


    /**
     * 获取Source的字符串名字
     */
    fun getName(): String = if (this is Enum<*>) this.toString() else javaClass.simpleName


    /**
     * 各平台对应的 AuthRequest 实现类
     */
    fun getTargetClass(): Class<out AuthDefaultRequest?>
}