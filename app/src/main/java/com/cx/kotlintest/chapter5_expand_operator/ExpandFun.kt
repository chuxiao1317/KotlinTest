package com.cx.kotlintest.chapter5_expand_operator

object ExpandFun {
    fun test() {
        // 调用顶层的扩展函数
        val count = "abcd123..".lettersCount()
        println("这是一个对String类添加的扩展方法，统计一个字符串中字母的位数：$count")

        "abcd123..".digitsCount()
    }

    /**
     * 非顶层类也能定义扩展函数，可调用范围待实战发现
     * */
    private fun String.digitsCount() {
        var count = 0
        for (char in this) {
            if (char.isDigit()) {
                count++
            }
        }
        println("非顶层类也可以定义扩展函数——统计字符串中数字的位数：$count")
    }

    /**
     * 调用顶层扩展函数 * 运算符重载
     * */
    fun operator() {
        // 调用顶层扩展的运算符重载函数：相乘
        val strTimes2 = "abc" * 2
        println("字符串（abc） * 2：$strTimes2")

        // 乘以一个随机数字
        val strRandom = "abc" * (1..20).random()
        println("字符串（abc） * n：$strRandom")
    }
}