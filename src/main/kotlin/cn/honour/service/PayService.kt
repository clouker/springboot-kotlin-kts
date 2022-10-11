//package cn.honour.service
//
//import cn.honour.core.R
//import cn.honour.core.fail
//import cn.honour.core.ok
//import cn.honour.core.okData
//import cn.honour.pay.alipay.AliPayManager
//import cn.honour.pay.alipay.AliPayTransfer
//import com.alipay.api.AlipayClient
//import com.alipay.api.domain.AlipayFundAccountQueryModel
//import com.alipay.api.domain.AlipayFundTransUniTransferModel
//import com.alipay.api.domain.Participant
//import com.alipay.api.request.AlipayFundAccountQueryRequest
//import com.alipay.api.request.AlipayFundTransUniTransferRequest
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.stereotype.Service
//
//@Service
//class AliPayService(@Value("\${spring.profiles.active}") val active: String) {
//
//    /**
//     * 支付宝可用余额查询
//     */
//    fun accountQuery(): R {
//
//        val alipayClient: AlipayClient = AliPayManager.initDefaultAlipayClient(active)
//        val request = AlipayFundAccountQueryRequest()
//        val model = AlipayFundAccountQueryModel().apply {
//            accountType = "ACCTRANS_ACCOUNT"
//            alipayUserId = "2088341083490673"
//        }
//
//        request.bizModel = model
//        val response = alipayClient.certificateExecute(request)
//        println(response.body)
//        return if (response.isSuccess) {
//            println("调用成功,可用余额为： ${response.availableAmount}")
//            okData(response.availableAmount)
//        } else {
//            println("调用失败,原因：${response.subMsg}")
//            fail("调用失败,原因：${response.subMsg}")
//        }
//
//    }
//
//    /**
//     * 支付宝转账服务
//     */
//    fun alipayTransfer(transferModel: AliPayTransfer): R {
//        //构造client
//        val alipayClient: AlipayClient = AliPayManager.initDefaultAlipayClient(active)
//        //构造API请求
//        val request = AlipayFundTransUniTransferRequest()
//        request.bizModel = AlipayFundTransUniTransferModel().apply {
//            outBizNo = transferModel.out_biz_no
//            transAmount = transferModel.trans_amount
//            productCode = transferModel.product_code
//            bizScene = transferModel.biz_scene
//            orderTitle = transferModel.order_title
//
//            payeeInfo = Participant().apply {
//                identity = transferModel.payee_info.identity
//                identityType = transferModel.payee_info.identity_type
//                name = transferModel.payee_info.name
//            }
//
//            remark = transferModel.remark
////            businessParams = "{\"payer_show_name_use_alias\":\"true\"}"
//        }
//        //发送请求
//        val response = alipayClient.certificateExecute(request)
//        println(response.body)
//        if (response.isSuccess) {
//            return ok("支付宝打款成功")
//        }
//        return fail(response.subMsg)
//    }
//}