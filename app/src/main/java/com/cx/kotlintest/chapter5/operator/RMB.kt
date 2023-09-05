package com.cx.kotlintest.chapter5.operator

class RMB(value: Float) : Money(value) {

    /**
     * 汇率：美元换人民币
     * */
    private val rate = 2

    operator fun plus(dollar: Dollar): RMB {
        val rmb = value + dollar.value * rate
        return RMB(rmb)
    }
}