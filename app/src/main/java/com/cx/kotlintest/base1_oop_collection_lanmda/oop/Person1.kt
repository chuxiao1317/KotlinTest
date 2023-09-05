package com.cx.kotlintest.base1_oop_collection_lanmda.oop

/**
 * open：kotlin默认一个类是不可以被继承的，对于需要被继承的类，需要添加open关键字
 *
 * class后面可以直接设置主构造犯法必须传入的参数
 * */
open class Person1(val name: String, val age: Int) {

    /**
     * 如果方法想要被重写，也必须open
     *
     * 在kotlin中，一个全局变量或方法默认是public的
     * */
    open fun eat() {
        println(name + "is eating. He is" + age + " years old.")
    }
}