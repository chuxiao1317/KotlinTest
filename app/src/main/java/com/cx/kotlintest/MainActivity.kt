package com.cx.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cx.kotlintest.base.For
import com.cx.kotlintest.base.If
import com.cx.kotlintest.base.When
import com.cx.kotlintest.oop.Phone
import com.cx.kotlintest.oop.Phone_data
import com.cx.kotlintest.oop.Student1
import kotlin.math.max

class MainActivity : AppCompatActivity() {

    /*永远优先使用常量，除非不得不使用变量*/
    private var a = 1// var 是可变变量
    private val b = 2// val 是不可变变量，即final，注意，js中并没有val，有的是var、let
    /*永远优先使用常量，除非不得不使用变量*/

    // 限定数据类型为int，注意，kotlin中，没有类似java的基本数据类型，全都是对象数据类型
    private val c: Int = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        base()
        oop()
    }

    private fun base() {
        getLargerNum(a, b)
        getLargerNum2(b, c)
        If.getLargerNum3(a, b)
        If.getLargerNum33(a, b)
        If.getLargerNum333(a, b)
        If.getLargerNum3333(a, b)
        When.getScoreByName("Tom")
        When.getScoreByName2("Tom")
        When.getScoreByName3("Tom")
        When.checkNumType(3)
        For.simpleFor()
    }

    private fun oop() {
        val stu = Student1("1", 2, "Tom", 3)
        stu.read()
        stu.doHomeWorks()

        val stu1 = Student1()
        stu1.eat()

        val phone = Phone("xiaomi", 1299.0)
        val phone1 = Phone("xiaomi", 1299.0)
        val phoneData = Phone_data("xiaomi", 1299.0)
        val phoneData1 = Phone_data("xiaomi", 1299.0)
        println("chuxiao oop(), phone: $phone")
        println("chuxiao oop(), phoneData: $phoneData")
        // 非数据类的两个对象即使参数完全一致，也不可能相等；但数据类同样的两个对象是可以相等
        println("chuxiao oop(), phone == phone1: " + (phone == phone1))// false
        println("chuxiao oop(), phoneData == phoneData1: " + (phoneData == phoneData1))// true
        // 数据类和非数据类的两个对象之间，不可以做如此判断：phone == phoneData
        //println("chuxiao oop(), phone == phoneData: " + (phone == phoneData))// error
    }

    /**
     * 定义一个双参方法，数据类型和返回值都是放在：后面
     * */
    private fun getLargerNum(a: Int, b: Int): Int {
        return max(a, b)
    }

    /**
     * 语法糖：若方法内部只有一行代码，则不用写{}，直接写在 = 后面
     * */
    private fun getLargerNum2(a: Int, b: Int): Int = max(a, b)
}