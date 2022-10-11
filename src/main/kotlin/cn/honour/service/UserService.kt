package cn.honour.service

import cn.honour.data.User
import cn.honour.mapper.UserMapper
import org.springframework.stereotype.Service

@Service
class UserService(val userMapper: UserMapper) {

    val all: List<User>
        get() = userMapper.selectList(User(id = 100001))

//    fun getOneById(id: Int): User {
//        return userRepository.getReferenceById(id)
//    }
//
//    fun addUser(user: User): User {
//        return userRepository.save(user)
//    }
//
//    fun updateUser(user: User): User {
//        return userRepository.save(user)
//    }
//
//    fun deleteUser(id: Int) {
//        userRepository.deleteById(id)
//    }
}