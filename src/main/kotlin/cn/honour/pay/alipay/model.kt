package cn.honour.pay.alipay

import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

data class AliPayTransfer(
    // 商户转账唯一订单号。发起转账来源方定义的转账单据ID，用于将转账回执通知给来源方。
    val out_biz_no: String,
    // 订单总金额，单位为元，不支持千位分隔符，精确到小数点后两位，取值范围[0.1,100000000]
    val trans_amount: String,
    // 销售产品码。单笔无密转账固定为 TRANS_ACCOUNT_NO_PWD。
    val product_code: String = "TRANS_ACCOUNT_NO_PWD",
    // 业务场景。单笔无密转账固定为 DIRECT_TRANSFER。
    val biz_scene: String = "DIRECT_TRANSFER",
    // 转账业务的标题，用于在支付宝用户的账单里显示。
    val order_title: String,
    // 收款方信息
    val payee_info: PayeeInfo,
    // 转账备注
    val remark: String = "",
)

data class PayeeInfo(
    // 参与方的标识 ID。
    //        //当 identity_type=ALIPAY_USER_ID 时，填写支付宝用户 UID。示例值：2088123412341234。
    //        //当 identity_type=ALIPAY_LOGON_ID 时，填写支付宝登录号。示例值：186xxxxxxxx。
    val identity: String,
    // 参与方的标识类型，目前支持如下枚举：
    //        // ALIPAY_USER_ID：支付宝会员的用户 ID，可通过 获取会员信息 能力获取。
    //        // ALIPAY_LOGON_ID：支付宝登录号，支持邮箱和手机号格式。
    val identity_type: String = "ALIPAY_LOGON_ID",
    //参与方真实姓名。如果非空，将校验收款支付宝账号姓名一致性。
    //   当 identity_type=ALIPAY_LOGON_ID 时，本字段必填。若传入该属性，则在支付宝回单中将会显示这个属性。
    val name: String
)

/**
 * 支付宝回调对象
 */
data class AliPayNotifyResponseModel(
    // 通知时间
    val notify_time: String? = null,
    // 通知类型
    val notify_type: String? = null,
    // 通知校验ID
    val notify_id: String? = null,
    // 应用Id
    val app_id: String? = null,
    // 编码格式
    val charset: String? = null,
    // 接口版本
    val version: String? = null,
    // 签名类型
    val sign_type: String? = null,
    // 签名
    val sign: String? = null,
    // 支付宝交易号
    val trade_no: String? = null,
    // 商户订单号
    val out_trade_no: String? = null,
    // 商户业务号
    val out_biz_no: String? = null,
    // 买家支付宝用户号
    val buyer_id: String? = null,
    // 买家支付宝账号
    val buyer_logon_id: String? = null,
    // 卖家支付宝用户号
    val seller_id: String? = null,
    // 卖家支付宝账号
    val seller_email: String? = null,
    // 交易状态
    val trade_status: String? = null,

    // 订单金额
    val total_amount: String? = null,
    // 实收金额
    val receipt_amount: String? = null,
    // 开票金额
    val invoice_amount: String? = null,
    // 付款金额
    val buyer_pay_amount: String? = null,
    // 集分宝金额
    val point_amount: String? = null,
    // 总退款金额
    val refund_fee: String? = null,

    // 订单标题
    val subject: String? = null,
    // 商品描述
    val body: String? = null,
    // 交易创建时间
    val gmt_create: String? = null,
    // 交易付款时间
    val gmt_payment: String? = null,
    // 交易退款时间
    val gmt_refund: String? = null,
    // 交易结束时间
    val gmt_close: String? = null,
    // 支付金额信息
    val fund_bill_list: String? = null,
    // 公共回传参数，如果请求时传递了该参数，则返回给商户时会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝
    val passback_params: String? = null,
    // 优惠券信息
    val voucher_detail_list: String? = null,
) {
    override fun toString(): String {
        var result = "aliPay--{"
        this::class.memberProperties.forEach {
            // 编译后，属性默认是private,需要设置isAccessible  才可以读取到值
            it.isAccessible = true
            println("\"${it.name}\":\"${it.call(this)}\",")
            result += "\"${it.name}\":\"${it.call(this)}\","
        }
        if (result.endsWith(',')) result = result.replaceFirst(".$".toRegex(), "")
        return "$result}"
    }
}