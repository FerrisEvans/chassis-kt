package cn.dd.sys.auth

import com.fasterxml.jackson.databind.node.ObjectNode

data class AuthUser(
    /**
     * 用户第三方系统的唯一id。在调用方集成该组件时，可以用uuid + source唯一确定一个用户
     */
    val uuid: String,
    /**
     * 用户名
     */
    val username: String,
    /**
     * 用户昵称
     */
    val nickname: String? = null,
    /**
     * 用户头像
     */
    private val avatar: String? = null,
    /**
     * 用户邮箱
     */
    val email: String? = null,
    /**
     * 用户备注（各平台中的用户个人介绍）
     */
    val remark: String? = null,
    /**
     * 性别
     */
    val gender: AuthUserGender = AuthUserGender.UNKNOWN,
    /**
     * 用户来源
     */
    val source: String,
    /**
     * 用户授权的token信息
     */
    val token: AuthToken? = null,
    /**
     * 第三方平台返回的原始用户信息
     */
    val raw: ObjectNode? = null,
)