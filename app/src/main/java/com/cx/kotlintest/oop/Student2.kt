package com.cx.kotlintest.oop

/**
 * 没有显示定义主构造函数
 * 即，只有次构造函数，没有主构造函数
 * */
class Student2 : Person {
    // 由于本类没有主构造函数，所以只能调用父类的主构造函数
    constructor(name: String, age: Int) : super() {
        println()
    }
}