package com.cx.kotlintest.base1_oop_collection_lanmda.oop

/**
 * 接口
 * */
interface Study {
    // 在kotlin中，一个全局变量或方法默认是public的
    fun read()// 这样的方法必须被实现

    fun doHomeWorks() {
        // java1.8、kotlin都允许在接口定义的函数中进行默认实现
        // 如此一来，这个方法就不是必须被实现的了
        println("我是接口的默认实现")
    }
}