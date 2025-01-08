package cn.dd.sys.auth.cache

/**
 * 默认的state缓存实现
 */
enum class AuthDefaultStateCache : AuthStateCache {
    /**
     * 当前实例
     */
    INSTANCE
    ;

    private val authCache: AuthCache = AuthDefaultCache()

    /**
     * 存入缓存
     *
     * @param key   缓存key
     * @param value 缓存内容
     */
    override fun cache(key: String, value: String) {
        authCache.set(key, value)
    }

    /**
     * 存入缓存
     *
     * @param key     缓存key
     * @param value   缓存内容
     * @param timeout 指定缓存过期时间（毫秒）
     */
    override fun cache(key: String, value: String, timeout: Long) {
        authCache.set(key, value, timeout)
    }

    /**
     * 获取缓存内容
     *
     * @param key 缓存key
     * @return 缓存内容
     */
    override fun get(key: String): String? {
        return authCache.get(key)
    }

    /**
     * 是否存在key，如果对应key的value值已过期，也返回false
     *
     * @param key 缓存key
     * @return true：存在key，并且value没过期；false：key不存在或者已过期
     */
    override fun containsKey(key: String): Boolean {
        return authCache.containsKey(key)
    }
}
