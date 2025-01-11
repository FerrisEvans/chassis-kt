package cn.dd.sys.rbac

import org.ktorm.entity.Entity
import org.ktorm.ksp.annotation.PrimaryKey
import org.ktorm.schema.*
import java.time.LocalDateTime


interface SysUser : Entity<SysUser> {
    @PrimaryKey
    val id: Long
    var version: Long
    var del: Boolean
    var createTime: LocalDateTime?
    var createBy: String?
    var updateTime: LocalDateTime?
    var updateBy: String?
    var username: String
    var password: String
    var nickname: String?
    var phone: String?
    var email: String?
    var enabled: Boolean
}

object SysUsers : Table<SysUser>("sys_user") {
    val id = long("id").primaryKey()
    val version = long("version")
    val del = boolean("del")
    val createTime = timestamp("create_time")
    val createBy = varchar("create_by")
    val updateTime = timestamp("update_time")
    val updateBy = varchar("update_by")
    val username = varchar("username")
    val password = varchar("password")
    val nickname = varchar("nickname")
    val phone = varchar("phone")
    val email = varchar("email")
    val enabled = boolean("enabled")
}
