package cn.dd.sys

import cn.dd.common.R
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/test")
    fun hello(): R<String> {
        return R.success("hello world")
    }

}