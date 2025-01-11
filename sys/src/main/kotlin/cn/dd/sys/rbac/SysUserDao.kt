package cn.dd.sys.rbac

import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SysUserDao {
    @Autowired
    private lateinit var database: Database

    fun getEmployeeById(id: Long): String {
        return database.from(SysUsers).select(SysUsers.username).where { SysUsers.id eq id }.sql
    }

}