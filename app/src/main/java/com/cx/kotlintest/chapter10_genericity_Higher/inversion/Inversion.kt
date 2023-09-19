package com.cx.kotlintest.chapter10_genericity_Higher.inversion

import com.cx.kotlintest.chapter10_genericity_Higher.Person

object Inversion {

    interface Transformer<T> {
        fun transform(t: T): String
    }

    /**
     * in关键字：声明逆变——泛型T只能出现在in位置
     * */
    interface Transformer1<in T> {
        fun transform(t: T): String
    }

    fun test() {
        val transPerson = object : Transformer<Person> {
            // 匿名实现
            override fun transform(t: Person): String {
                return "泛型逆变，${t.name}, ${t.age}"
            }
        }
        val transPerson1 = object : Transformer1<Person> {
            // 匿名实现
            override fun transform(t: Person): String {
                return "泛型逆变，${t.name}, ${t.age}"
            }
        }
        // todo 这行代码会报错，因为数据类型不匹配，存在类型转换错误的安全隐患，原理详见P424
        //handleTransformer(transPerson)
        // todo 这行不会报错，因为已经声明逆变
        handleTransformer1(transPerson1)
    }

    private fun handleTransformer(trans: Transformer<Person.Student>) {
        val student = Person.Student("张三", 19)
        val result = trans.transform(student)
    }

    private fun handleTransformer1(trans: Transformer1<Person.Student>) {
        val student = Person.Student("张三", 19)
        val result = trans.transform(student)
        println(result)
    }
}