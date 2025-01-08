package cn.dd.sys.auth.cache

interface AuthStateCache {
    /**
     * 存入缓存
     *
     * @param key   缓存key
     * @param value 缓存内容
     */
    fun cache(key: String, value: String)

    /**
     * 存入缓存
     *
     * @param key     缓存key
     * @param value   缓存内容
     * @param timeout 指定缓存过期时间（毫秒）
     */
    fun cache(key: String, value: String, timeout: Long)

    /**
     * 获取缓存内容
     *
     * @param key 缓存key
     * @return 缓存内容
     */
    fun get(key: String): String?

    /**
     * 是否存在key，如果对应key的value值已过期，也返回false
     *
     * @param key 缓存key
     * @return true：存在key，并且value没过期；false：key不存在或者已过期
     */
    fun containsKey(key: String): Boolean
}