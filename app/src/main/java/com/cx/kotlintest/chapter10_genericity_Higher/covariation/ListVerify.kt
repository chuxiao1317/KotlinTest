package com.cx.kotlintest.chapter10_genericity_Higher.covariation

import com.cx.kotlintest.chapter10_genericity_Higher.Person

object ListVerify {
    fun verify() {
        val listStu = listOf(Person.Student("张三", 19), Person.Student("李四", 20))
        // todo 这在java当中是不允许的，会标红报错
        handleData(listStu)
    }

    /**
     * List已被Kotlin声明协变，可参考SimpleList代码
     * */
    private fun handleData(data: List<Person>) {
        for (item in data) {
            println("List本身已经声明协变, ${item.name},${item.age}")
        }
    }
}