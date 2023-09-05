package com.cx.kotlintest.chapter5_expand_operator.operator

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