package cn.dd.sys.auth.cache

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantReadWriteLock

class AuthDefaultCache(
    private val cacheLock: ReentrantReadWriteLock = ReentrantReadWriteLock(true),
    private val writeLock: Lock = cacheLock.writeLock(),
    private val readLock: Lock = cacheLock.readLock(),
    private val stateCache: MutableMap<String, CacheState> = ConcurrentHashMap(),
) : AuthCache {

    init {
        if (AuthCache.schedulePrune) {
            this.schedulePrune(AuthCache.timeout)
        }
    }

    /**
     * 设置缓存
     *
     * @param key   缓存KEY
     * @param value 缓存内容
     */
    override fun set(key: String, value: String) {
        set(key, value, AuthCache.timeout)
    }

    /**
     * 设置缓存
     *
     * @param key     缓存KEY
     * @param value   缓存内容
     * @param timeout 指定缓存过期时间（毫秒）
     */
    override fun set(key: String, value: String, timeout: Long) {
        writeLock.lock()
        try {
            stateCache[key] = CacheState(value, timeout)
        } finally {
            writeLock.unlock()
        }
    }

    /**
     * 获取缓存
     *
     * @param key 缓存KEY
     * @return 缓存内容
     */
    override fun get(key: String): String? {
        readLock.lock()
        try {
            val cacheState = stateCache[key]
            if (null == cacheState || cacheState.isExpired()) {
                return null
            }
            return cacheState.state
        } finally {
            readLock.unlock()
        }
    }

    /**
     * 是否存在key，如果对应key的value值已过期，也返回false
     *
     * @param key 缓存KEY
     * @return true：存在key，并且value没过期；false：key不存在或者已过期
     */
    override fun containsKey(key: String): Boolean {
        readLock.lock()
        try {
            val cacheState = stateCache[key]
            return null != cacheState && !cacheState.isExpired()
        } finally {
            readLock.unlock()
        }
    }

    /**
     * 清理过期的缓存
     */
    override fun pruneCache() {
        val values = stateCache.values.iterator()
        var cacheState: CacheState
        while (values.hasNext()) {
            cacheState = values.next()
            if (cacheState.isExpired()) {
                values.remove()
            }
        }
    }

    /**
     * 定时清理
     *
     * @param delay 间隔时长，单位毫秒
     */
    private fun schedulePrune(delay: Long) {
        AuthCacheScheduler.INSTANCE.schedule({ this.pruneCache() }, delay)
    }

}

class CacheState(val state: String, expire: Long) {
    private val expire = System.currentTimeMillis() + expire

    fun isExpired(): Boolean = expire > System.currentTimeMillis()
}
