package com.cx.kotlintest.chapter8_genericity_entrust.entrust.byLazy

object ByLazy_Mine {

    private var b = "012"

    /**
     * by是关键字，lazy是一个自己仿写的lazy高阶函数
     * */
    private val a by myLazy {
        println("自定义懒加载：这里只有a首次被调用时执行，且只执行一次")
        //b += b.length
        //b// todo：这里放开注释运行会报错
    }

    fun test() {
        println("自定义懒加载：第一次打印a：$a")
        println("自定义懒加载：第二次打印a：$a")
        println("自定义懒加载：第三次打印a：$a")
    }
}