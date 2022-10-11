package cn.honour.data

import io.mybatis.provider.Entity.*
import java.sql.Timestamp

@Table("user")
data class User(
    @Column(id = true) val id: Int? = null,
    @Column val name: String? = null,
    @Column val passwd: String? = null,
    @Column val phone: String? = null,
    @Column val avatar: String? = null,
    @Column val email: String? = null,
    @Column val sex: Short? = null,
    @Column val status: Short? = null,
    @Column("createTime") val createTime: Timestamp? = null,
    @Column("updateTime") val updateTime: Timestamp? = null
) {
    override fun toString(): String {
        return "User{id=$id, name='$name', passwd=$passwd, phone='$phone, email='$email'}"
    }
}