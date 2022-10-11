package cn.honour.core

import cn.honour.core.R.Companion.ERROR
import cn.honour.core.R.Companion.FAIL
import cn.honour.core.R.Companion.OK

// 统一返回对象
class R(
    private val code: Int, private val msg: String, private val data: Any?
) {
    companion object {
        const val OK = 10000
        const val FAIL = 60000
        const val ERROR = 50000
    }

    override fun toString() = "R(code : $code , msg : $msg , data : $data)"
}

// 成功处理
fun ok(msg: String = "it's ok. over！！！") = R(OK, msg, null)

fun ok(msg: String = "it's ok. over！！！", data: Any?) = R(OK, msg, data)

fun okData(data: Any?) = R(OK, "", data)

// 业务异常
fun fail(msg: String = "it's failed. over！！！") = R(FAIL, msg, null)

fun fail(msg: String = "it's failed. over！！！", data: Any?) = R(FAIL, msg, data)

// 服务器异常
fun error(msg: String = "it's error. over！！！") = R(ERROR, msg, null)

fun error(msg: String = "it's error. over！！！", data: Any?) = R(ERROR, msg, data)