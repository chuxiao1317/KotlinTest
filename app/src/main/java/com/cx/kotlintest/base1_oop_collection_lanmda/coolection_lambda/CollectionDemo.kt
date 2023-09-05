package com.cx.kotlintest.base1_oop_collection_lanmda.coolection_lambda

object CollectionDemo {
    fun listof() {
        // listof：创建一个不可变的list——只能读取，不可增删改
        val list = listOf("苹果", "香蕉", "橘子", "桃子")
        for (item in list) {
            println("list:$item")
        }
    }

    fun mutableListOf() {
        // mutableListOf：创建一个可变的list——可增删改查
        val list = mutableListOf("苹果", "香蕉", "橘子", "桃子")
        list.add("西瓜")// 可以增删改查
        for (item in list) {
            println("mutableListOf:$item")
        }
    }

    fun setof() {
        // listof：创建一个不可变的set——只能读取，不可增删改
        val list = setOf("苹果", "香蕉", "橘子", "桃子")
        for (item in list) {
            println("setof:$item")
        }
    }

    fun mutableSetOf() {
        // mutableListOf：创建一个可变的set——可增删改查
        val list = mutableSetOf("苹果", "香蕉", "橘子", "桃子")
        list.add("西瓜")// 可以增删改查
        for (item in list) {
            println("mutableSetOf:$item")
        }
    }

    /**
     * 类似java的map读取写法，但是kotlin并不建议这样写
     * */
    fun mapJava() {
        val map = HashMap<String, Int>()
        map.put("苹果", 1)
        map.put("香蕉", 2)
        map.put("橘子", 3)
        for (item in map) {
            println("mapJava:" + item.key + "," + item.value)
        }
    }

    /**
     * kotlin建议按照类似数组的读取写法
     * */
    fun mapKT() {
        val map = HashMap<String, Int>()
        map["苹果"] = 4
        map["香蕉"] = 5
        map["橘子"] = 6
        for ((name, num) in map) {
            println("mapKT:$name,$num")
        }
    }

    /**
     * 最简单的map创建方法
     * */
    fun mapKT_simple() {
        // 不可变
        val map = mapOf("苹果" to 7, "香蕉" to 8, "橘子" to 9)
        // 可变
        val map2 = mutableMapOf("苹果" to 7, "香蕉" to 8, "橘子" to 9)
        map2["西瓜"] = 10
        for ((name, num) in map) {
            println("mapKT_simple:$name,$num")
        }
        for ((name, num) in map2) {
            println("mapKT_simple_可变:$name,$num")
        }
    }
}