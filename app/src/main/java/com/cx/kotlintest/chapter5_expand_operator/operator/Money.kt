package com.cx.kotlintest.chapter5_expand_operator.operator

/**
 * 函数和表达式对应表
 * a.plus(b)：求和
 * a.minus(b)：相减
 * a.times(b)：相乘
 * a.div(b)：相除
 * a.rem(b)：取余%
 * a.inc：a++
 * a.dec：a--
 * a.unaryPlus：+a
 * a.unaryMinus：-a
 * a.not：!a
 * a.equals(b)：a==b
 * a.compareTo(b)：比较大小，包括：>、<、>=、<=
 * a.rangeTo(b)：a..b
 * a.get(b)：a[b]
 * a.set(b,c)：a[b] = c
 * b.contains(a)：a in b
 * */
open class Money(val value: Float) {
    /**
     * operator:实现运算符重载的关键字
     * plus：求和
     * */
    operator fun plus(money: Money): Money {
        val sum = value + money.value
        // 求和之后，返回一个新的对象
        return Money(sum)
    }

    /**
     * 用于实现：让对象和数字相加
     * */
    operator fun plus(newValue: Int): Money {
        val sum = value + newValue
        return Money(sum)
    }
}