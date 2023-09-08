package com.cx.kotlintest.chapter6_higherFun

object Noinline {

    /**
     * noinline:inline关键字会将所有引用的lambda默认内联，若要其中一些不内联，可以用noinline关键字
     *
     * todo：内联函数的函数型参数只允许传给另一个内联函数，而非内联函数的函数型参数可以自由传递
     * todo：这个特性待实战验证
     * */
    inline fun noinlineTest(method1: () -> Unit, noinline method2: () -> Unit) {}

    fun inlineMain() {
        println("内联main, 开始")
        val str = ""
        printString1(str) { s ->
            println("内联lambda,开始")
            if (s.isEmpty()) return
            println(s)
            println("内联lambda 被提前return了")
        }
        println("内联main 被提前return了")
    }

    /**
     * 内联函数所引用的lambda表达式中可以使用return进行返回，直接中断函数往下执行
     * */
    private inline fun printString1(str: String, block: (String) -> Unit) {
        println("内联printString，开始")
        block(str)
        println("内联printString，被提前return了")
    }


    fun noinlineMain() {
        println("非内联main, 开始")
        val str = ""
        printString2(str) { s ->
            println("非内联lambda,开始")
            if (s.isEmpty()) return@printString2
            println(s)
            println("非内联lambda 被局部return")
        }
        println("非内联main 没被return")
    }

    /**
     * 非内联函数只能用return@方法名 来进行局部返回
     * */
    private fun printString2(str: String, block: (String) -> Unit) {
        println("非内联printString，开始")
        block(str)
        println("非内联printString，没被return")
    }
}