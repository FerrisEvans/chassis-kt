package cn.dd.common.exception

import cn.dd.common.dict.BizCode

class BizException(val code: Int, val msg: String) : RuntimeException(msg) {
    constructor(bizCode: BizCode) : this(bizCode.code, bizCode.name)
    constructor(bizCode: BizCode, msg: String) : this(bizCode.code, msg)
}