package cn.dd.sys.auth.req

import cn.dd.common.R
import cn.dd.sys.auth.*

interface AuthRequest {
    /**
     * 返回带`state`参数的授权url，授权回调时会带上这个`state`
     *
     * @param state 验证授权流程的参数，可以防止csrf
     * @return 返回授权地址
     */
    fun authorize(state: String?): String {
        throw AuthException(AuthResponseStatus.NOT_IMPLEMENTED)
    }

    /**
     * 获取access token
     *
     * @param authCallback 授权成功后的回调参数
     * @return token
     * @see AuthDefaultRequest.authorize
     * @see AuthDefaultRequest.authorize
     */
    fun getAccessToken(authCallback: AuthCallback?): AuthToken?

    /**
     * 使用token换取用户信息
     *
     * @param authToken token信息
     * @return 用户信息
     * @see AuthDefaultRequest.getAccessToken
     */
    fun getUserInfo(authToken: AuthToken?): AuthUser?

    /**
     * 第三方登录
     *
     * @param authCallback 用于接收回调参数的实体
     * @return 返回登录成功后的用户信息
     */
    fun login(authCallback: AuthCallback?): R<AuthUser> {
        throw AuthException(AuthResponseStatus.NOT_IMPLEMENTED)
    }

    /**
     * 刷新access token （续期）
     *
     * @param authToken 登录成功后返回的Token信息
     * @return AuthResponse
     */
    fun refresh(authToken: AuthToken?): R<AuthToken> {
        throw AuthException(AuthResponseStatus.NOT_IMPLEMENTED)
    }
}