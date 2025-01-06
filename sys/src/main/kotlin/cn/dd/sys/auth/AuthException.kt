package cn.dd.sys.auth

class AuthException (val code: Int, val msg: String) : RuntimeException(msg) {
    constructor(errorMsg: String) : this(AuthResponseStatus.FAILURE.code, errorMsg)
    constructor(status: AuthResponseStatus) : this(status.code, status.msg)
}