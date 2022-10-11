//package cn.honour.controller
//
//import cn.honour.core.R
//import cn.honour.core.fail
//import cn.honour.pay.alipay.AliPayTransfer
//import cn.honour.service.AliPayService
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.*
//
//@RequestMapping("pay/ali")
//@RestController
//class ALiPayController() {
//
//    @Autowired
//    lateinit var aliPayService: AliPayService
//
//    /**
//     * 支付宝转账
//     */
//    @PostMapping("transfer")
//    fun aliPayTransfer(@RequestBody aliPayTransferModel: AliPayTransfer? = null): R {
//        if (aliPayTransferModel == null) return fail("非法请求")
//
//        return aliPayService.alipayTransfer(aliPayTransferModel)
//    }
//
//    /**
//     * 账户余额
//     */
//    @GetMapping("account")
//    fun account() =  aliPayService.accountQuery()
//}
//
//@RequestMapping("pay/wechat")
//@RestController
//class WeChatPayController {
//
//    @GetMapping("test")
//    fun test() = listOf("test", 1, 2, 3, 4, 5, "流弊")
//
//}
//
//
