package com.cx.kotlintest.base3

import android.util.Log

/**
 * 标准函数是指Standard.kt中定义的函数，比如let
 * */
object StandardFun {
    private val list = listOf("苹果", "香蕉", "西瓜")

    /**
     * 此处多次调用了同一个对象builder的方法，在代码逻辑较长时是一种冗余的写法
     * */
    fun repeatCall() {
        val builder = StringBuilder()
        builder.append("开始吃水果")
        for (item in list) {
            builder.append("，").append(item)
        }
        builder.append("，吃完了。")
        // print和println默认调用了传入对象的toString方法，因此不必调用toString
        println(builder)
    }

    /**
     * repeatCall简洁化
     * */
    fun with() {
        // 由于第二个参数（最后一个）是一个lambda表达式，因此可以写在()外面，看起来像只有一个参数
        val result = with(StringBuilder()) {
            // 在with方法体内，每一行代码都是为with方法传入参数的第一个对象服务的
            append("用with方法吃水果")
            for (item in list) {
                append("，").append(item)
            }
            append("，吃完了。")
            toString()// 最后一行代码的执行结果作为返回值
        }
        println(result)
    }

    /**
     * run函数的具体功能跟with相似，只是语法有区别
     * */
    fun run() {
        // run函数必须由具体的对象调用，且只传入一个lambda表达式作为参数，精简后看起来像无参函数
        val result = StringBuilder().run {
            // 在run方法体内，每一行代码都是为with方法传入参数的第一个对象服务的
            append("用run方法吃水果")
            for (item in list) {
                append("，").append(item)
            }
            append("，吃完了。")
            toString()// 最后一行代码的执行结果作为返回值
        }
        println(result)
    }

    /**
     * run、with、apply功能和使用场景相似，大多数情况下都可以互相替代，只是语法有区别
     * */
    fun apply() {
        // 类似于run函数，apply函数必须由具体的对象调用，且只传入一个lambda表达式作为参数，精简后看起来像无参函数
        // apply函数最终会返回调用对象本身，无法指定别的返回值
        val result = StringBuilder().apply {
            // 在apply方法体内，每一行代码都是为with方法传入参数的第一个对象服务的
            append("用apply方法吃水果")
            for (item in list) {
                append("，").append(item)
            }
            append("，吃完了。")
        }
        // 由于没有指定返回值，因而此处必须重新调用toString
        Log.d("Log", result.toString())
        // print和println默认调用了传入对象的toString方法，因此不必调用toString
        println(result)
    }
}