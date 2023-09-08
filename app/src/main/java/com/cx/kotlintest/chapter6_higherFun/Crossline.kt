package com.cx.kotlintest.chapter6_higherFun

object Crossline {
    /**
     * 绝大多数高阶函数都可以添加inline设置成内联函数，但也有少部分例外，如下
     * */
    inline fun runRunnable(block: () -> Unit) {
        val runnable = Runnable {
            // 这里是一个高阶函数的匿名实现类，不允许使用return返回外层函数，最多返回匿名类的函数，
            // 与内联函数的lambda允许使用return的机制造成冲突
            // 因此添加inline后，这行代码会报错
            //block()
        }
    }

    /**
     * 优化runRunnable()
     * */
    inline fun runRunnable1(crossinline block: () -> Unit) {
        val runnable = Runnable {
            // crossinline:相当于一个契约，保证不会使用return，消解编译冲突
            // 于是添加crossinline关键字后，这里不再报错
            block()
            // 这样一来不能再使用return，但可以用reuturn@runRunnable1来局部返回
            // 除了不能使用return，crossinline保留了内联函数的其它所有特性
            return@Runnable
        }
    }
}