package com.cx.kotlintest.base1_oop_collection_lanmda.coolection_lambda

object Lambda {
    private val fruitList = listOf("苹果", "梨", "哈密瓜")

    /**
     * 最原始的写法：遍历集合取最大值
     * */
    fun getLongestFruit() {
        var longestFruit = ""
        for (item in fruitList) {
            if (item.length > longestFruit.length) {
                longestFruit = item
            }
        }
        println("getLongestFruit:$longestFruit")
    }

    /**
     * 更简单的从集合中取最大值的写法
     * */
    fun getLongestFruit2() {
        // lambda的完整写法：{参数1：参数类型，参数2：参数类型 -> 函数体}
        val lambda = { name: String -> name.length }
        // maxBy：集合的一种函数API——取最大值，它的参数是一个
        val longestFruit = fruitList.maxBy(lambda)

        println("getLongestFruit:$longestFruit")
    }

    /**
     * getLongestFruit2()简化版
     * */
    fun getLongestFruit22() {
        println("getLongestFruit22: " + fruitList.maxBy({ name: String -> name.length }))
    }

    /**
     * getLongestFruit22()简化版
     * */
    fun getLongestFruit222() {
        // 当lambda参数是函数的最后一个参数时，可把lambda表达式放到（）外面，使得maxBy像无参函数
        println("getLongestFruit222-1: " + fruitList.maxBy() { name: String -> name.length })
        // 如果lambda是唯一参数，可省略（）
        println("getLongestFruit222-2: " + fruitList.maxBy { name: String -> name.length })
        // lambda表达式中在大多数情况下不必声明参数类型
        println("getLongestFruit222-3: " + fruitList.maxBy { name -> name.length })
    }

    /**
     * 最简单的从集合中取最大值的写法
     * */
    fun getLongestFruit_simple() {
        // it关键字：若lambda表达式只有一个参数，不必声明参数名，用it替代
        println("getLongestFruit_simple: " + fruitList.maxBy { it.length })
    }
}