package cn.dd.common.dao

import org.ktorm.entity.Entity
import java.time.LocalDateTime

interface BaseEntity<T : Entity<T>> : Entity<T> {
    val id: Long
    var version: Long
    var del: Boolean
    var createTime: LocalDateTime?
    var createBy: String?
    var updateTime: LocalDateTime?
    var updateBy: String?
}