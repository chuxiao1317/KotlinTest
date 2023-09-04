package com.cx.kotlintest.chapter4

object LateInit {
    /**
     * lateinit：延迟初始化一个变量，这样可以避免后续代码判空
     * */
    private lateinit var str: String

    fun doIt() {
        // ::x.isInitialized: 固定写法，判断变量是否已经初始化
        // 如果不能保证变量已经初始就需要这样写，不然可能运行报错
        if (!::str.isInitialized) {
            str = "123"
            println("延迟初始化变量：$str")
        }
    }
}