package com.cx.kotlintest.base1_oop_collection_lanmda.oop

/**
 * 继承Person类
 * Person(): kotlin沿袭java规定——子类构造函数必须调用父类构造方法,所以带()
 * 此处定义主构造函数必须传入两个参数
 *
 * 注意后子类名的后两个参数，不能添加var或val，否则会跟父类变量冲突
 *
 * Study:实现接口不用带()，因为接口没有构造函数
 * */
class Student1(val studyNum: String, val grade: Int, name: String, age: Int) : Person1(name, age),
    Study {
    init {// 主构造方法的方法体（叫init结构体），绝大多数场景无需编写
        println("学号：$studyNum")
        println("年级：$grade")
    }

    /**
     * 次构造函数：必须调用主构造函数（包括间接调用）
     * */
    constructor(name: String, age: Int) : this("", 0, name, age) {

    }

    /**
     * 次次构造函数：间接调用主构造函数
     * */
    constructor() : this("", 0) {

    }

    /**
     * 重写父类方法，父方法必须open
     * */
    override fun eat() {}

    override fun read() {
        // 重写接口方法必须实现逻辑，不实现会闪退报错：Not yet implemented
        println("实现接口read方法")
    }
}