package com.cx.kotlintest.chapter9_infix

/**
 * infix函数：优化可读性
 * */
object Infix {
    fun test() {
        old()
        new()
        advance()
    }

    private fun old() {
        if ("123".startsWith("12")) {
            println()
        }
    }

    private fun new() {
        if ("123" myStartWith "12") {
            println()
        }
    }

    /**
     * 为String类扩展一个myStartWith函数
     * 然后用infix关键字修饰，使之可以用strA myStartWith strB的方式调用
     *
     * infix不能定义为顶层函数，必须是某个类的成员函数
     * infix必须且只能接收一个参数
     * */
    infix fun String.myStartWith(str: String) = startsWith(str)

    infix fun <T> Collection<T>.has(item: T) = contains(item)

    // 仿写一个 to 函数
    // 用法见CollectionDemo: mapKT_simple()
    infix fun <A, B> A.myTo(that: B): Pair<A, B> = Pair(this, that)

    private fun advance() {
        val list = listOf("苹果", "香蕉")
        // 调用 has 函数
        if (list has "香蕉") {
            println("infix函数：有香蕉")
        }
        if (!(list has "橘子")) {
            println("infix函数：没有橘子")
        }

        // 调用 myTo 函数
        val map = mapOf("苹果" myTo 1, "香蕉" myTo 2)
        for ((name, num) in map) {
            println("infix函数：${name}有${num}个")
        }
    }
}