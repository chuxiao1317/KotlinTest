package com.cx.kotlintest.chapter5.operator

class Dollar(value: Float) : Money(value) {
    /**
     * 汇率：人民币换美元
     * */
    private val rate = 0.5f

    operator fun plus(rmb: RMB): Dollar {
        val dollar = value + rmb.value * rate
        return Dollar(dollar)
    }
}