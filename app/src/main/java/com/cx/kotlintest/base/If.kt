package com.cx.kotlintest.base

/**
 * class开头的是普通类
 * object开头的是单例类，单例类里面的方法都是可以直接用类名调用的，类似静态方法，但只能在被kotlin调用
 * */
object If {

    /**
     * if返回值
     * */
    fun getLargerNum3(a: Int, b: Int): Int {
        // 在kotlin中，if可以有返回值
        val value = if (a >= b) {
            a
        } else {
            b
        }
        return value
    }

    /**
     * getLargerNum3简化
     * */
    fun getLargerNum33(a: Int, b: Int): Int {
        return if (a >= b) {
            a
        } else {
            b
        }
    }

    /**
     * getLargerNum33简化
     * */
    fun getLargerNum333(a: Int, b: Int): Int = if (a >= b) {
        a
    } else {
        b
    }

    /**
     * getLargerNum333简化
     * 注意：kotlin中没有a = true? a: b这种“三元条件运算符”的写法
     * */
    fun getLargerNum3333(a: Int, b: Int): Int = if (a >= b) a else b
}