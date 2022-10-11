package cn.honour.utils

import cn.honour.core.R
import cn.honour.core.fail
import cn.honour.core.ok
import cn.honour.core.okData
import kotlin.math.*

/**
 * 查询输入是否为靓号
 * ---两位及以上豹子号
 * ---三位及以上顺子号（正反）
 */
fun String.goodNum(): R {

    // 长度4-11
    if (!this.matches(Regex("^([1-9][0-9]{3,10})$"))) return fail("非有效数字")

    // 匹配3位连续的数字
    if (this.matches(Regex("(?:(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){2}|(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){2})\\d"))) return ok(
        "3位连续的数字", true
    )

    // 匹配4位重复数字
    if (this.matches(Regex("(\\d)\\1{3}"))) return ok(
        "4位重复数字", true
    )
//    if (this.matches(Regex("(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){5}\\d"))) return ok(
//        "6位顺增",
//        true
//    )
//
//    if (this.matches(Regex("(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){5}\\d"))) return ok(
//        "6位顺降",
//        true
//    )

    // 匹配6位顺增或顺降
//    if (this.matches(Regex("(?:(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){5}|(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){5})\\d"))) return ok(
//        "6位顺增或顺降", true
//    )
    return ok("未匹配", false)
}

/**
 * 匹配手机号
 */
fun String.isMobile() = okData(this.matches(Regex("(13|14|15|18|17)[0-9]{9}")))


/**
 * 默认地球半径
 */
const val EARTH_RADIUS = 6371000.0 //赤道半径(单位m)

/**
 * 转化为弧度(rad)
 */
private fun rad(d: Double) = d * Math.PI / 180.0

/**
 * 根据经纬度获取两点距离
 * @param c1 第一点的精纬度
 * @return 返回的距离，单位m
 */
fun String.distance(c1: String?) =
    if (c1.isNullOrBlank() || !c1.contains(",") || this.isBlank() || !this.contains(",")) null
    else distance(
        this.split(",")[0].toDouble(),
        this.split(",")[1].toDouble(),
        c1.split(",")[0].toDouble(),
        c1.split(",")[1].toDouble()
    )

/**
 * 根据经纬度获取两点距离
 * @param lon1 第一点的精度
 * @param lat1 第一点的纬度
 * @param lon2 第二点的精度
 * @param lat2 第二点的纬度
 * @return 返回的距离，单位m
 */
fun distance(lon1: Double, lat1: Double, lon2: Double, lat2: Double): String {
    val radLat1 = rad(lat1)
    val radLat2 = rad(lat2)
    val a = radLat1 - radLat2
    val b = rad(lon1) - rad(lon2)
    var s = 2 * asin(
        sqrt(
            sin(a / 2).pow(2.0) + cos(radLat1) * cos(radLat2) * sin(b / 2).pow(2.0)
        )
    )
    s *= EARTH_RADIUS
    s = ((s * 10000).roundToInt() / 10000).toDouble()
    return s.absoluteValue.toString()
}
