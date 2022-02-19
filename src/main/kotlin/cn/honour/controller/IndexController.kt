package cn.honour.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @RequestMapping("test")
    fun test() = Result.success("It's ok.")

    @RequestMapping("test1")
    fun test1() = listOf("one","two","three")

}