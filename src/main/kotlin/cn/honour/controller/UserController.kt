package cn.honour.controller

import cn.honour.data.User
import cn.honour.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController(val userService: UserService) {

    @GetMapping("findAll")
    fun findAll(): List<User> = userService.all

//    @GetMapping("add")
//    fun addOne(): User {
//        val user = User(null, "张三", 20, "北京市石景山区")
//        return userService.addUser(user)
//    }
//
//    @GetMapping("update")
//    fun updateOne(): User {
//        return userService.updateUser(User(13, "李四", address = "搬到了山西省太原市"))
//    }
//
//    @GetMapping("delete")
//    fun deleteOne(): String {
//        try {
//            userService.deleteUser(35)
//        } catch (e: Exception) {
//            return "删除失败"
//        }
//        return "删除成功"
//    }
}