package cn.dd.common.exception

import org.springframework.http.HttpStatus

enum class BizCode(val code: Int) {
    SUCCESS(HttpStatus.OK.value()),
    NO_AUTH(HttpStatus.UNAUTHORIZED.value()),
    ACCESS_DENIED(HttpStatus.FORBIDDEN.value()),
    NOT_FOUND(HttpStatus.NOT_FOUND.value()),
//    PWD_WRONG(), 密码错误
//    USER_EXISTS(), 用户已存在
    SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value()),
    ;
}