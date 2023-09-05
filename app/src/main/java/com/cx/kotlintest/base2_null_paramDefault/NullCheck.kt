package com.cx.kotlintest.base2_null_paramDefault

import com.cx.kotlintest.base1_oop_collection_lanmda.oop.Student
import com.cx.kotlintest.base1_oop_collection_lanmda.oop.Study

object NullCheck {
    /**
     * kotlin默认所有传参都是不能为空的，传null就会报错
     *
     * 如果确实可能需要传null，就要在定义方法的时候在参数类型后面加上【?】
     * 这个时候就必须判空，否则编译不过
     * */
    fun checkNull_if(study: Study?) {
        // 用if判空是最普通的写法，但是代码不够简洁
        // 且if判空无法处理全局变量判空的问题,全局变量有可能被其它线程赋空
        if (study == null) {
            return
        }
        study.read()
        study.doHomeWorks()
    }

    /**
     * 【?.】：非空执行，否则什么也不做
     * 如果是返回值就返回null
     * */
    fun checkNull_kt1(study: Study?) {
        study?.read()
        study?.doHomeWorks()
    }

    /**
     * val c = a ?: b
     * 【?:】：非空赋a，否则赋b
     * */
    fun checkNull_kt2(student: Student?) {
        val STU = Student("10086", 7)
        // 如果student不为空就把它赋值给stu，否则把STU赋值给stu
        val stu = student ?: STU
        stu.eat()
    }

    /**
     * 功能：传入一个可能为空的字符串，返回它的长度，如果为空返回0
     *
     * 逻辑：若text?.length整体不为空，就返回text.length，否则返回0
     * 本来text.length不可能为null，但当text == null时，text?.length会返回null
     *
     * 这里的逻辑相当于return (text?.length) ?: 0
     * 人的理解顺序：先阅读括号外，再阅读括号内
     * 实际执行顺序：先执行括号内，再执行括号外
     * */
    fun checkNull_kt1_kt2(text: String?) = text?.length ?: 0


    // 1.一个可能为空的全局变量
    private var content: String? = "hello"

    // 2.外部判空
    fun checkNull_global_assert() {
        if (content != null) {
            printUpperCase()
        }
    }

    // 3.非空断言
    private fun printUpperCase() {
        // 这行代码无法编译通过，因为此处并不知道外部已经对content进行判空（就算外部已经判空，其实全局变量也有可能重新被其它线程赋空）
        //println("printUpperCase: ${content.uppercase()}")

        // !!.操作符：非空断言-即强制执行，代表开发者确信操作对象不会为空；但这是一种有风险的写法
        println("printUpperCase: ${content!!.uppercase()}")
    }

    /**
     * let函数：传入study函数本身到lambda表达式中，以便一次判空执行多个方法，避免多次判空
     * */
    fun let(study: Study?) {
        study?.let {
            it.read()
            it.doHomeWorks()
        }
        content?.let {
            // let函数可以处理全局变量判空问题, 这种方法显然优于有风险的断言判空方法
            println("let: ${it.uppercase()}")
        }
    }
}