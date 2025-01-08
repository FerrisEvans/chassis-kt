package cn.dd.sys.auth.cache

import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/**
 * 缓存调度器
 */
enum class AuthCacheScheduler {

    /**
     * 当前实例
     */
    INSTANCE
    ;

    private val cacheTaskNumber = AtomicInteger(1)
    private var scheduler: ScheduledExecutorService? = null

    init {
        create()
    }

    private fun create() {
        this.shutdown()
        this.scheduler = ScheduledThreadPoolExecutor(10) { r: Runnable? ->
            Thread(r, String.format("JustAuth-Task-%s", cacheTaskNumber.getAndIncrement()))
        }
    }

    fun schedule(task: Runnable, delay: Long) {
        scheduler!!.scheduleAtFixedRate(task, delay, delay, TimeUnit.MILLISECONDS)
    }

    private fun shutdown() {
        if (null != scheduler) {
            scheduler!!.shutdown()
        }
    }

}