package cn.dd.common.dao

import org.ktorm.entity.Entity
import org.ktorm.ksp.annotation.PrimaryKey
import java.time.LocalDateTime

interface BaseEntity<T : Entity<T>> : Entity<T> {
    @PrimaryKey
    val id: Long
    var version: Long
    var del: Boolean
    var createTime: LocalDateTime?
    var createBy: String?
    var updateTime: LocalDateTime?
    var updateBy: String?
}