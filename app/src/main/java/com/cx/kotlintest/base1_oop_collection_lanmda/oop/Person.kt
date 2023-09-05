package com.cx.kotlintest.base1_oop_collection_lanmda.oop

/**
 * open：kotlin默认一个类是不可以被继承的，对于需要被继承的类，需要添加open关键字
 * */
open class Person {
    var name = ""
    var age = 0

    // 在kotlin中，一个全局变量或方法默认是public的
    fun eat() {
        println(name + "is eating. He is" + age + " years old.")
    }
}