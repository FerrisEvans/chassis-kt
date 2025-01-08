package cn.dd.sys.auth.cache

interface AuthCache {

    companion object {
        /**
         * 默认缓存过期时间：3分钟
         * 鉴于授权过程中，根据个人的操作习惯，或者授权平台的不同，每个授权流程的耗时也有差异，不过单个授权流程一般不会太长
         * 默认的过期时间设置为3分钟，即程序默认认为3分钟内的授权有效，超过3分钟则默认失效，失效后删除
         */
        var timeout: Long = (3 * 60 * 1000).toLong()

        /**
         * 是否开启定时[AuthDefaultCache.pruneCache]的任务
         */
        var schedulePrune: Boolean = true
    }

    /**
     * 设置缓存
     *
     * @param key   缓存KEY
     * @param value 缓存内容
     */
    fun set(key: String, value: String)

    /**
     * 设置缓存，指定过期时间
     *
     * @param key     缓存KEY
     * @param value   缓存内容
     * @param timeout 指定缓存过期时间（毫秒）
     */
    fun set(key: String, value: String, timeout: Long)

    /**
     * 获取缓存
     *
     * @param key 缓存KEY
     * @return 缓存内容
     */
    fun get(key: String): String?

    /**
     * 是否存在key，如果对应key的value值已过期，也返回false
     *
     * @param key 缓存KEY
     * @return true：存在key，并且value没过期；false：key不存在或者已过期
     */
    fun containsKey(key: String): Boolean

    /**
     * 清理过期的缓存
     */
    fun pruneCache() {}
}