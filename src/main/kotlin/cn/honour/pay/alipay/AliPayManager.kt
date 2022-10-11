//package cn.honour.pay.alipay
//
//import cn.honour.pay.alipay.AliPayManager.Dev.devInitCertAlipayRequest
//import cn.honour.pay.alipay.AliPayManager.Prod.prodInitCertAlipayRequest
//import cn.honour.pay.alipay.AliPayManager.Test.testInitCertAlipayRequest
//import com.alipay.api.CertAlipayRequest
//import com.alipay.api.DefaultAlipayClient
//
//object AliPayManager {
//
//    fun initDefaultAlipayClient(active: String) = DefaultAlipayClient(
//        CertAlipayRequest().apply {
//            //设置请求格式，固定值json
//            format = AliPayManager.format
//            //设置字符集
//            charset = AliPayManager.charset
//            //设置签名类型
//            signType = AliPayManager.signType
//            when (active) {
//                "dev" -> devInitCertAlipayRequest()
//                "test" -> testInitCertAlipayRequest()
//                "prod" -> prodInitCertAlipayRequest()
//            }
//        }
//    )
//
//    object Dev {
//
//        fun CertAlipayRequest.devInitCertAlipayRequest() = this.apply {
//            //设置网关地址
//            serverUrl = "https://openapi.alipaydev.com/gateway.do"
//            //设置应用Id
//            appId = app_id
//            //设置应用私钥
//            privateKey = merchant_private_key
//            // 设置应用公钥证书路径
//            certPath = APP_CERT_PATH
//            //设置支付宝公钥证书路径
//            alipayPublicCertPath = ALIPAY_CERT_PATH
//            //设置支付宝根证书路径
//            rootCertPath = ALIPAY_ROOT_CERT_PATH
//        }
//
//        /**
//         * 应用公钥证书路径
//         */
//        private const val APP_CERT_PATH =
//            "A:\\project\\java\\mukui\\zxys-api\\src\\main\\resources\\cert\\dev\\appCertPublicKey_2021000118666573.crt"
//
//        /**
//         * 支付宝公钥证书路径
//         */
//        private const val ALIPAY_CERT_PATH =
//            "A:\\project\\java\\mukui\\zxys-api\\src\\main\\resources\\cert\\dev\\alipayCertPublicKey_RSA2.crt"
//
//        /**
//         * 支付宝根证书路径
//         */
//        private const val ALIPAY_ROOT_CERT_PATH =
//            "A:\\project\\java\\mukui\\zxys-api\\src\\main\\resources\\cert\\dev\\alipayRootCert.crt"
//
//        /**
//         * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
//         */
//        private const val app_id = "2021000118666573"
//
//        /**
//         * 私钥，您的PKCS8格式RSA2私钥(应用私钥)
//         */
//        private const val merchant_private_key =
//            "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCY70Qbtq6+wQ+ZRX8U4NtdZ6XWKwLAovuvO+OQ+ecp6nVu8gmwl8f2732h2f9hbJgAJVJRfwXU4hWmEwnQhPu0oenyCSlDpFbsPePJK2Nvk3+RVuc+McYZwRImmLSdL9qdDqv2oQ0E0VGoR+FvQYmOJ1CGweKxzy442zfmBVmA3ZtaJuGipOHgnAbC2EEUkTrzzJfQU9oGPlh32IT/eEVD2KZ0wr7rrpMteoiazAd0ikY+Tp1Rsi+C4DDKcb8cCqfJtm/GiNDcHt1TlPiI8sChvRLEYqgNbKU/GU2rQPe3rWkWpkrjfoTmW5v27jrpT2BgcjZ855kgEZj1vJc44snHAgMBAAECggEAGN5ng94sAkbgo3rilGGQKlstY2sxEmQuaytg8PVCOtWubPEc1EOKN8Rv+H67gXsoKHXpMelm6FwvSwczhF3rlE7z/PCybhZuMBJMVS0iCUXB679m8P0lCpETw4T3ccwTT5DQM9WyiUMEdUnjBbVxidUoyhEDLQjUqlgzecsK5+JgGmU57Y/QXy1/NCDPOAoH2OJX5iOivzUnC40tR5fYdE6LAWvAEXSk8ZYuE+Td7e5kZujAsJ4fX3xCzRT/u1CzN9Q0pwtW5fuzZ9swfnQSiWQhrdmeqz5N2wdx9WC3dYc+FkFConyZEcq4U0JDzTDxrmsJHZVT//OUtLAlOLuaGQKBgQDqGKjq+EKNVI9Q2/w+q7m5udRuDshr3bJOEbIU716zVcrWJDR29GtvM37GxFYwndEpFUTQxj2d7+SJcL2q6aCEVD3xf9kBtpoDnxzSUbd+7/0m8WW3Z/lY8x0KQMs8pjtc0MZeC5JkRfXjY2/4OlHn1xeDru7pMS0RbT2eOAgRYwKBgQCnPoeKW0M5Qi+UvJrUe8n7tyqQ5NgDsppBZFfaxerrKsfzb3QiOQRKPNVCIt/4vQMXy9SBG4S2JQtPHDZmxrbyg4mJgyZVfhjKiKnRYSLHVx+fSo+tMkppHWyKmLvOYDIu7KZGi/vlecBaMfNdexv1IPZlDiWeMsnNKnRPJfjlTQKBgGAVHQfMO+ysP2KN2DuU2lcbqdA+aw6y4ONgKfqjwPfUh7tbAtmsOoha13cX0NSFgfrdyu/x3gp8Ew5CYubKm2KU/ROpSNWGMDK6VOcSOUF1mS8pt3kOyO40Yr/5ljFffU/8NN8W2tAjUugwwR1eOo3w36rh2xeFYp0bfEX7c3xHAoGAXgUWF57ktMzTiO9ar3eD/oFjaZ9tHO8MLxTlGvVG8rvTOrR+ejrJgZ6fWRXYCbLgiUEqjwZUXj2HFQtMPg0ajk2KRYc4Rrmj4EBiD3ZnId+FxHwbN4fdMyi6e1QPyJ5lt+GMPH63trLygwIvyW7LMcw9GGSSm1P8BN4IEvLK8MUCgYA32I1J2aRzZpRcyPtqaN4Fundm8VrQbNnMkQK7JmbMUEDN6d3yd4HrZ8Mpv4Gv7H3uWtD0wghUYFo/b5f/2bbn6x4MJaF6COuv9oTeSsjKAM84pT0zaxzGxLMPeutHB7Ftpo/wvYAJ3bL2iGSzmtafYDzVOo/Hk/ruixRly9mOgA=="
//
//    }
//
//    object Test {
//
//        fun CertAlipayRequest.testInitCertAlipayRequest() = this.apply {
//            //设置网关地址
//            serverUrl = "https://openapi.alipay.com/gateway.do"
//            //设置应用Id - 零端科技
//            appId = "2021003129673010"
//            //设置应用私钥
//            privateKey = merchant_private_key
//            //设置应用公钥证书路径
//            certPath = APP_CERT_PATH
//            //设置支付宝公钥证书路径
//            alipayPublicCertPath = ALIPAY_CERT_PATH
//            //设置支付宝根证书路径
//            rootCertPath = ALIPAY_ROOT_CERT_PATH
//        }
//
//        /**
//         * 应用公钥证书路径
//         */
//        private const val APP_CERT_PATH =
//            "A:\\project\\java\\mukui\\zxys-api\\src\\main\\resources\\cert\\prod\\appCertPublicKey_2021003129673010.crt"
//
//        /**
//         * 支付宝公钥证书路径
//         */
//        private const val ALIPAY_CERT_PATH =
//            "A:\\project\\java\\mukui\\zxys-api\\src\\main\\resources\\cert\\prod\\alipayCertPublicKey_RSA2.crt"
//
//        /**
//         * 支付宝根证书路径
//         */
//        private const val ALIPAY_ROOT_CERT_PATH =
//            "A:\\project\\java\\mukui\\zxys-api\\src\\main\\resources\\cert\\prod\\alipayRootCert.crt"
//
//        /**
//         * 私钥，您的PKCS8格式RSA2私钥(应用私钥)
//         */
//        private const val merchant_private_key =
//            "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQChqsXeQb1IVs46dJnk9Huwrvq3BJAz6/DD/lWVCAVMT6nIE8ZuzodpOL5/pnUIadxXcQ2ES6n4S50QjVqvTj4bS6Et1aB4kIVAvu/5CZ+ZjEmXo8hUgQJepO2evBFCQRo7kqhruhUdtFxlz7ErR6WZO8kdRsjl8slCFFuMcmZiTHkzvsgQIppHe+VCGIH7FgxBW/IxUFGEauzFrL9wO1yUhT+aKhN5OL6r55DyLcegIBPAarBwRSN0usxMBDItOGFV9KWfKloK/tVRrGSVGJqbER6Z0KQeZ0Ehi2ECSwI+4C/gVrAZYUjL2zAgZKOYTCBpI6NWBO5kJGHKXP6XqnJlAgMBAAECggEAY1sFsftq7ctTgP9qGRjb75EKSnJGgXJujLWBOU8tmmGXMXxdxnmtJNCX2vGdGWed4Ct9qCGsOwmVZLfK1NRcPQA09WtF7PK8wjbWWpI8gOyDyesBUlXa8/meg6CHZtWF3rjaQyKgmZnf8z46XyPwNQVWK2T2UMPuRmsmfGFOZPgnzh8JuT805l3neyBYYgHECeTO2lhR5OXlY33r+KUkzi8OPjbn+tn3QPOjdJYOG79qVsKdyW6qeKeQiWlJ9xFHyhebh78HV6pw4J6oTBDgCEqHeVTBwWX58S1e+S5IjsTAIQ64IlgKMAY6rXEIb1wg9n6AJYGC7LU5Tw0wx3Yz3QKBgQDs0VzT0rOKZYO12nJnP48U6iY1fPPrUTYZeG4F33fRYGJGBTnj7z9uq6pfec37+f5X/8Dy6OAbW3q4t0sBUepYASIPgMB9g8UucAkoL0iY8vqpAFOrIM0nRYrjheb+OJ8ZY9ZpHFmB29wy+KaBHP0wXiurSENgkjjEKV6hIqdkVwKBgQCuwxcGO2GcoeCA9VTKAL/R9pmUG56BnKwrfrLvS53JTk+7Js6f9xTAKL8U4SseeZxyprsdN8oXp/LC1a0jM6UlaOLL64LgxqWHT5LeqvIKygGMt5hSZjeBO22+A8Pie8sj9lVkaoybgbKv6156WCS5u70DXGne1P1HZt8OetWJowKBgGuaTYVpzW5q5cexdB35wTeNlMLk/afEhMJZ+BPvD/AwzTZnlYA96yKMGaO8Ip4FX034xWEZ8wo7LK3Vit0UrVhDW4iTxeLCBsws19xMb74fWUmE/n9ZLh5T+OGcq/KDI7dTp86mtPzOO2VlmbI8y8Y4Y7s14Hd2uRhYe8jXiBuNAoGAXp6b6bDe4ao3Xjr2BESxlqF4d1sYz74e7ZG0maEMNgDjZEXXm35wSrYE9u4OpXpcfSrOpjwde/9fjaOZETUWFhIasSO7Aa4r0v3/W/WcBMFoY2LH4t0a8ipV+YoaVZaG3tqxUyPpKwzmzR6XUZBFmhYOeTJg09fnpfAJltJkqRcCgYBWISDL7Phy1g3+UX9EFK7efSxxahrIlhQ/G48tcBi6LVz7ySqnye+uPRu4F1ufUV+yVj7T6+OKTo2sCKtiajNkeVFfAZbWZg83Dgf6TAG7RCw+/htNV5v8rakdCi3G76JAdM152e2E7NFVJiNbeAwujvjYUxt/PeFMzTD6REHzKg=="
//    }
//
//    object Prod {
//
//        fun CertAlipayRequest.prodInitCertAlipayRequest() = this.apply {
//            //设置网关地址
//            serverUrl = "https://openapi.alipay.com/gateway.do"
//            //设置应用Id - 零端科技
//            appId = "2021003129673010"
//            //设置应用私钥
//            privateKey = merchant_private_key
//            //设置应用公钥证书路径
//            certPath = APP_CERT_PATH
//            //设置支付宝公钥证书路径
//            alipayPublicCertPath = ALIPAY_CERT_PATH
//            //设置支付宝根证书路径
//            rootCertPath = ALIPAY_ROOT_CERT_PATH
//        }
//
//        /**
//         * 应用公钥证书路径
//         */
//        private const val APP_CERT_PATH = "C:\\res\\prod\\appCertPublicKey_2021003129673010.crt"
//
//        /**
//         * 支付宝公钥证书路径
//         */
//        private const val ALIPAY_CERT_PATH = "C:\\res\\prod\\alipayCertPublicKey_RSA2.crt"
//
//        /**
//         * 支付宝根证书路径
//         */
//        private const val ALIPAY_ROOT_CERT_PATH = "C:\\res\\prod\\alipayRootCert.crt"
//
//        /**
//         * 私钥，您的PKCS8格式RSA2私钥(应用私钥)
//         */
//        private const val merchant_private_key =
//            "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQChqsXeQb1IVs46dJnk9Huwrvq3BJAz6/DD/lWVCAVMT6nIE8ZuzodpOL5/pnUIadxXcQ2ES6n4S50QjVqvTj4bS6Et1aB4kIVAvu/5CZ+ZjEmXo8hUgQJepO2evBFCQRo7kqhruhUdtFxlz7ErR6WZO8kdRsjl8slCFFuMcmZiTHkzvsgQIppHe+VCGIH7FgxBW/IxUFGEauzFrL9wO1yUhT+aKhN5OL6r55DyLcegIBPAarBwRSN0usxMBDItOGFV9KWfKloK/tVRrGSVGJqbER6Z0KQeZ0Ehi2ECSwI+4C/gVrAZYUjL2zAgZKOYTCBpI6NWBO5kJGHKXP6XqnJlAgMBAAECggEAY1sFsftq7ctTgP9qGRjb75EKSnJGgXJujLWBOU8tmmGXMXxdxnmtJNCX2vGdGWed4Ct9qCGsOwmVZLfK1NRcPQA09WtF7PK8wjbWWpI8gOyDyesBUlXa8/meg6CHZtWF3rjaQyKgmZnf8z46XyPwNQVWK2T2UMPuRmsmfGFOZPgnzh8JuT805l3neyBYYgHECeTO2lhR5OXlY33r+KUkzi8OPjbn+tn3QPOjdJYOG79qVsKdyW6qeKeQiWlJ9xFHyhebh78HV6pw4J6oTBDgCEqHeVTBwWX58S1e+S5IjsTAIQ64IlgKMAY6rXEIb1wg9n6AJYGC7LU5Tw0wx3Yz3QKBgQDs0VzT0rOKZYO12nJnP48U6iY1fPPrUTYZeG4F33fRYGJGBTnj7z9uq6pfec37+f5X/8Dy6OAbW3q4t0sBUepYASIPgMB9g8UucAkoL0iY8vqpAFOrIM0nRYrjheb+OJ8ZY9ZpHFmB29wy+KaBHP0wXiurSENgkjjEKV6hIqdkVwKBgQCuwxcGO2GcoeCA9VTKAL/R9pmUG56BnKwrfrLvS53JTk+7Js6f9xTAKL8U4SseeZxyprsdN8oXp/LC1a0jM6UlaOLL64LgxqWHT5LeqvIKygGMt5hSZjeBO22+A8Pie8sj9lVkaoybgbKv6156WCS5u70DXGne1P1HZt8OetWJowKBgGuaTYVpzW5q5cexdB35wTeNlMLk/afEhMJZ+BPvD/AwzTZnlYA96yKMGaO8Ip4FX034xWEZ8wo7LK3Vit0UrVhDW4iTxeLCBsws19xMb74fWUmE/n9ZLh5T+OGcq/KDI7dTp86mtPzOO2VlmbI8y8Y4Y7s14Hd2uRhYe8jXiBuNAoGAXp6b6bDe4ao3Xjr2BESxlqF4d1sYz74e7ZG0maEMNgDjZEXXm35wSrYE9u4OpXpcfSrOpjwde/9fjaOZETUWFhIasSO7Aa4r0v3/W/WcBMFoY2LH4t0a8ipV+YoaVZaG3tqxUyPpKwzmzR6XUZBFmhYOeTJg09fnpfAJltJkqRcCgYBWISDL7Phy1g3+UX9EFK7efSxxahrIlhQ/G48tcBi6LVz7ySqnye+uPRu4F1ufUV+yVj7T6+OKTo2sCKtiajNkeVFfAZbWZg83Dgf6TAG7RCw+/htNV5v8rakdCi3G76JAdM152e2E7NFVJiNbeAwujvjYUxt/PeFMzTD6REHzKg=="
//    }
//
//    /**
//     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问（可以使用natapp内容穿透完成外网设置）
//     */
//    const val notify_url = "异步通知url/web/aliPay/aliPayCallBack"
//
//    /**
//     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//     */
//    const val return_url = "同步通知url"
//
//    /**
//     * 传参方式
//     */
//    private const val format = "json"
//
//    /**
//     * 签名方式  固定
//     */
//    private const val signType = "RSA2"
//
//    /**
//     * 字符编码格式  固定
//     */
//    private const val charset = "UTF8"
//
//}