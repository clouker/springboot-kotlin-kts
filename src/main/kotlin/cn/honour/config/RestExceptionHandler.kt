package cn.honour.config

import cn.honour.core.R
import cn.honour.core.error
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class RestExceptionHandler {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun handler(e: Exception, req: HttpServletRequest): R {
        logger.error("全局异常--e:${e}, ${req.requestURI}")
        logger.error("      --message:${e.message}")
        logger.error("      --printStackTrace:${e.printStackTrace()}")
        return error("服务器压力太大了哟，让它缓上一缓！！！", e.message)
    }
}