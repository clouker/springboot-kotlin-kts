package cn.honour.mapper

import cn.honour.data.User
import io.mybatis.mapper.Mapper
import org.springframework.stereotype.Repository

@Repository
interface UserMapper : Mapper<User, Int> {
}