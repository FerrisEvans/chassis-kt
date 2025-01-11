package cn.dd.sys

import cn.dd.common.R
import cn.dd.sys.rbac.SysUserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    lateinit var sysUserDao: SysUserDao

    @GetMapping("/test")
    fun hello(): R<String> {
        return R.success(sysUserDao.getEmployeeById(1))
    }

}