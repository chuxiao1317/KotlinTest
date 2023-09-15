package com.cx.kotlintest.chapter8_genericity_entrust.entrust.byLazy

object ByLazy {

    private var b = "012"

    /**
     * by是关键字，lazy是一个高阶函数
     * */
    private val a by lazy {
        println("懒加载：这里只有a首次被调用时执行，且只执行一次")
        b += b.length
        b
    }

    fun test() {
        println("懒加载：第一次打印a：$a")
        println("懒加载：第二次打印a：$a")
        println("懒加载：第三次打印a：$a")
    }
}