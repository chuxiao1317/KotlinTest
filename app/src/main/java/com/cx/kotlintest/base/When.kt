package com.cx.kotlintest.base

/**
 * class开头的是普通类
 * object开头的是单例类，单例类里面的方法都是可以直接用类名调用的，类似静态方法
 * */
object When {

    /**
     * when: 替代java中的switch
     * when也跟if一样，可以有返回值
     * */
    fun getScoreByName(name: String) = when (name) {
        "Tom" -> {
            86
        }
        "Jack" -> {
            95
        }
        else -> {
            0
        }
    }

    fun getScoreByName2(name: String) = when (name) {
        "Tom" -> 86
        "Jack" -> 95
        "Marry" -> {
            100 - 13// 若此处只有一行代码，可以省略{}
        }
        else -> 0
    }

    /**
     * when不带参数，直接在主体内部判断数据类型
     * */
    fun getScoreByName3(name: String) = when {
        name.startsWith("Tom") -> 86// 这种判断也无法用when(name)来进行
        name.startsWith("Jack") -> 95
        name == "Marry" -> 87
        else -> 0
    }

    /**
     * 判断数据类型
     * is 相当于java的 instanceof
     * */
    fun checkNumType(num: Number): String = when (num) {
        is Int -> "Int"
        is Double -> "Double"
        else -> "unknown"
    }
}