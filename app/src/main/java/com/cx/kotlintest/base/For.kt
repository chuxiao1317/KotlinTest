package com.cx.kotlintest.base

/**
 * class开头的是普通类
 * object开头的是单例类，单例类里面的方法都是可以直接用类名调用的，类似静态方法
 * */
object For {
    fun simpleFor() {
        // 遍历[0,10]: 两端闭区间
        for (i in 0..10) {
            println("chuxiao simpleFor, $i")
        }
        // until：遍历[0,10)：左闭右开, 据说更常用
        for (i in 0 until 10) {
            println("chuxiao simpleFor2, $i")
        }
        // step: 跳过某个item
        for (i in 0 until 10 step 2) {
            println("chuxiao simpleFor3, $i")
        }
        // downTo：降序区间
        for (i in 10 downTo 0) {
            println("chuxiao simpleFor4, $i")
        }
    }
}