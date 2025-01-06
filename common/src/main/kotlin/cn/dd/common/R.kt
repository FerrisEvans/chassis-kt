package cn.dd.common

import org.springframework.http.HttpStatus

data class R<T>(
    val success: Boolean,
    val data: T? = null,
    val msg: String,
    val code: Int
) {
    companion object {
        fun <T> ok(data: T): R<T> {
            return R(true, data, HttpStatus.OK.reasonPhrase, HttpStatus.OK.value())
        }

        fun <T> error(): R<T> {
            return R(
                true,
                null,
                HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,
                HttpStatus.INTERNAL_SERVER_ERROR.value()
            )
        }

        fun <T> error(code: Int, msg: String): R<T> {
            return R(false, null, msg, code)
        }

        fun <T> notFound(): R<T> {
            return R(false, null, HttpStatus.NOT_FOUND.reasonPhrase, HttpStatus.NOT_FOUND.value())
        }

        fun <T> notFound(obj: Any): R<T> {
            return R(
                false,
                null,
                obj.toString() + " " + HttpStatus.NOT_FOUND.reasonPhrase,
                HttpStatus.NOT_FOUND.value()
            )
        }
    }
}