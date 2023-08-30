package com.cx.kotlintest.coolection_lambda

/**
 * 集合的函数式API显然很多，这里只是举例最常用的
 * */
object CollectionAPI {
    private val list = listOf("Apple", "Banana", "Orange")

    /**
     * map-API：映射转换——将集合按一定规则,重写变为另一个集合
     * */
    fun mapAPI() {
        // uppercase：将所有水果名称变为大写
        val newList = list.map { it.uppercase() }
        // 判断每个item字母长度是否小于5
        val newList1 = list.map { it.length <= 5 }

        for (item in newList) {
            println("mapAPI-uppercase: $item")
        }
        for (item in newList1) {
            println("mapAPI-boolean: $item")
        }
    }

    /**
     * 过滤某些item
     * */
    fun filter() {
        // 保留字母长度在5以内的水果
        val newList = list.filter { it.length <= 5 }

        for (item in newList) {
            println("filter: $item")
        }
    }

    /**
     * API连用
     * */
    fun filterMap() {
        // 保留字母长度在5以内的水果，并将之转换为大写
        // 注意：先过滤，再进行映射转换，较节约时间；反过来也能用，但浪费时间
        val newList = list.filter { it.length <= 5 }.map { it.uppercase() }

        for (item in newList) {
            println("filterMap: $item")
        }
    }

    fun any_all() {
        // any：是否至少存在一个元素满足指定条件
        val anyResult = list.any { it.length <= 5 }
        // all：是否所有元素满足指定条件
        val allResult = list.all { it.length <= 5 }

        println("anyResult: $anyResult, allResult: $allResult")
    }
}