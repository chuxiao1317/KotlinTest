package com.cx.kotlintest.chapter8_genericity_entrust

/**
 * 基础泛型用法，类似于java
 *
 * 一般情况下，我们需要给变量指定具体类型，而泛型允许我们不指定变量类型
 * */
object Genericity {

    fun toClass() {
        val a = GenericityClass<Int>()
        val result = a.method(123)
        println("泛型类，执行结果：$result")

    }

    fun <T> toMethod(param: T): T {
        println("泛型方法，执行结果：$param")
        return param
    }

    fun <T : Number> toMethodNum(param: T): T {
        println("限制上界为数字类型的泛型方法，执行结果：$param")
        return param
    }

    /**
     * 不指定上界类型时，泛型的默认上界是Any?，即可以为null，若想限制为不可为空，可指定上界为Any
     * */
    fun <T : Any> toMethod_NoNull(param: T): T {
        println("限制上界为数字类型的泛型方法，执行结果：$param")
        return param
    }

    /**
     * 对未知泛型类扩展 * 高阶函数
     * */
    fun <T> T.apply2(block: T.() -> Unit): T {
        block()
        return this
    }
}