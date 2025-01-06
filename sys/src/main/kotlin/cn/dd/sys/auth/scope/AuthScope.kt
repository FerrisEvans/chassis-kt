package cn.dd.sys.auth.scope

interface AuthScope {
    /**
     * 获取字符串 `scope`，对应为各平台实际使用的 `scope`
     *
     * @return String
     */
    fun scope(): String

    /**
     * 判断当前 `scope` 是否为各平台默认启用的
     *
     * @return boolean
     */
    fun default(): Boolean
}