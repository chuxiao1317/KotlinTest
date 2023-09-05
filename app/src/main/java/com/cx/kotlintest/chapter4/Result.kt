package com.cx.kotlintest.chapter4

/**
 * 密封类
 * */
sealed class Result {
    // 子类继承Result
    class Success(val msg: String) : Result()
    class Fail(val msg: String) : Result()

    /**
     * when语句传入一个密封类变量作为条件时，kotlin编译器会自动检查该类有哪些子类，并强制要求将每一个子类所对应的条件全部处理
     * 这样可以不用写else
     * 这时如果新增一个Unknown子类，printResultMsg就会报错，必须增加一个is Unknown的条件分支才能解决编译报错
     *
     * 密封类及其所有子类只能定义在同一个文件的顶层位置，不能嵌套在其他类中
     * */
    fun printResultMsg(result: Result) = when (result) {
        is Success -> println("getResultMsg: ${result.msg}")
        is Fail -> println("getResultMsg: ${result.msg}")
    }
}