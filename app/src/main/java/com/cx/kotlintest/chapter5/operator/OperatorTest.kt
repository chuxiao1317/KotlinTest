package com.cx.kotlintest.chapter5.operator

/**
 * 运算符重载的测试类
 * */
object OperatorTest {
    fun test() {
        val money1 = Money(1f)
        val money2 = Money(2f)
        val rmb = RMB(1f)
        val dollar = Dollar(1f)

        // 两个对象相加
        val money3 = money1 + money2
        println("让两个对象相加：1元 + 2元 = ${money3.value}元")

        // 对象和数字相加
        val money4 = money1 + 5
        println("对象和数字相加：1元 + 5 = ${money4.value}元")

        // 人民币和美元相加，返回人民币
        val resultRmb = rmb + dollar
        println("人民币和美元相加：1元 + 1美元 = ${resultRmb.value}元")

        // 美元和人民币相加，返回美元
        val resultDollar = dollar + rmb
        println("美元和人民币相加：1美元 + 1元 = ${resultDollar.value}美元")
    }
}