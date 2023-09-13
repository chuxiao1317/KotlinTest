package com.cx.kotlintest.chapter6_higherFun

/**
 * 高阶函数
 * */
object HigherFun {

    /**
     * ->：指定返回值类型
     * Unit：相当于void
     * func：自定义函数名；这个函数可以有多个参数，也可以没有参数
     * */
    private fun example(func: (String) -> Unit) {
        func("高阶函数举例")
    }

    /**
     * 定义一个高阶函数，它可以传入一个方法作为参数，这个方法有两个int参数，返回值是int
     *
     * inline: 内联函数关键字，可以消除lambda创建匿名类带来的额外运行时开销；
     * inline不写也不会有大问题，但最好还是写上
     * */
    private inline fun compute(num1: Int, num2: Int, method: (Int, Int) -> Int) = method(num1, num2)

    fun base() {
        // 【::】：引用一个函数
        example(::println)

        val plus = compute(1, 2, ::plus)
        val minus = compute(2, 1, ::minus)
        println("高阶函数——1、2求和：$plus")
        println("高阶函数——2、1求差：$minus")
    }

    /**
     * 用lambda简化调用高阶函数：不用额外定义一个plus或minus函数
     * */
    fun lambda() {
        val plus1 = compute(1, 2) { n1, n2 ->
            n1 + n2
        }
        val minus1 = compute(1, 2) { n1, n2 ->
            n2 - n1
        }
        println("用lambda简化调用高阶函数——1、2求和：$plus1")
        println("用lambda简化调用高阶函数——2、1求差：$minus1")
    }

    // 作为参数的方法，但可用lambda替代
    private fun plus(num1: Int, num2: Int) = num1 + num2

    // 作为参数的方法，但可用lambda替代
    private fun minus(num1: Int, num2: Int) = num1 - num2
}