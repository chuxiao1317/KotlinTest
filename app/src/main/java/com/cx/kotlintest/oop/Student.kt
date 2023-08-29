package com.cx.kotlintest.oop

/**
 * 继承Person类
 * Person(): kotlin沿袭java规定——子类构造函数必须调用父类构造方法,所以带()
 * 此处定义主构造函数必须传入两个参数
 * */
class Student(val studyNum: String, val grade: Int) : Person() {
    init {// 主构造方法的方法体（叫init结构体），绝大多数场景无需编写
        println("学号：$studyNum")
        println("年级：$grade")
    }
}