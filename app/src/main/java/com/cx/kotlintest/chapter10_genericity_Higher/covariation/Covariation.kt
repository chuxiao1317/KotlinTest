package com.cx.kotlintest.chapter10_genericity_Higher.covariation

import com.cx.kotlintest.chapter10_genericity_Higher.Person

/**
 * 协变
 * */
object Covariation {

    class SimpleData<T> {
        private var data: T? = null
        fun set(t: T?) {
            data = t
        }

        fun get(): T? {
            return data
        }
    }

    /**
     * out关键字：声明为协变——只读，不可删改——泛型T只能出现在out位置
     *
     * 构造函数参数：由于是一次性赋值，因此还是只读的
     * */
    class SimpleData1<out T>(private val data: T?) {

        fun get(): T? {
            return data
        }
    }

    /**
     * 这里是为了便于理解协变
     * */
    fun test() {
        val student = Person.Student("张三", 19)

        val simpleStudent = SimpleData<Person.Student>()
        simpleStudent.set(student)

        // 由构造函数传值，而不是set
        val simpleStudent1 = SimpleData1(student)

        // java这行不会报错
        handlePerson(student)

        // todo 这行代码会报错, 包括在java里面；因为存在类型转换错误的安全隐患，就像子方法那样使用，原理详见P420
        //handleSimpleData(simpleStudent)
        // todo 这行就不会报错了, 因为声明了协变
        handleSimpleData1(simpleStudent1)
    }

    fun handleSimpleData(simplePerson: SimpleData<Person>) {
        val teacher = Person.Teacher("李四老师", 35)
        simplePerson.set(teacher)
    }

    private fun handleSimpleData1(simplePerson: SimpleData1<Person>) {
        val person = simplePerson.get()
        println("泛型协变，${person?.name}, ${person?.age}")
    }

    private fun handlePerson(person: Person) {
        val teacher = Person.Teacher("李四老师", 35)
    }
}