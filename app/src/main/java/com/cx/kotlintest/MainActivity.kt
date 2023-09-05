package com.cx.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cx.kotlintest.base.For
import com.cx.kotlintest.base.If
import com.cx.kotlintest.base.When
import com.cx.kotlintest.base2.ParamDefault
import com.cx.kotlintest.coolection_lambda.CollectionAPI
import com.cx.kotlintest.coolection_lambda.CollectionDemo
import com.cx.kotlintest.coolection_lambda.JavaAPI
import com.cx.kotlintest.coolection_lambda.Lambda
import com.cx.kotlintest.base2.NullCheck
import com.cx.kotlintest.oop.Phone
import com.cx.kotlintest.oop.Phone_data
import com.cx.kotlintest.oop.Student1
import com.cx.kotlintest.base3.StandardFun
import com.cx.kotlintest.base3.StaticFun
import com.cx.kotlintest.base3.topStatic
import com.cx.kotlintest.chapter4.LateInit
import com.cx.kotlintest.chapter4.Result
import com.cx.kotlintest.chapter5.ExpandFun
import com.cx.kotlintest.chapter5.operator.OperatorTest
import kotlin.math.max

class MainActivity : AppCompatActivity() {

    /*永远优先使用常量，除非不得不使用变量*/
    private var a = 1// var 是可变变量
    private val b = 2// val 是不可变变量，即final，注意，js中并没有val，有的是var、let
    /*永远优先使用常量，除非不得不使用变量*/

    // 限定数据类型为int，注意，kotlin中，没有类似java的基本数据类型，全都是对象数据类型
    private val c: Int = 10

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // 基础：if、when、for-in循环
        base()
        // 面相对象编程：继承、重写、实现、主次构造方法、单例类
        oop()
        // 集合、集合的常用函数API、lambda表达式
        collection_lambda()
        // 判空、let函数、参数默认值、键值对传参
        base2()
        // 标准函数、静态方法、顶层方法
        base3()
        // 延迟初始化、密封类-优化多余的when-else
        chapter4()
        // 扩展函数、运算符重载
        chapter5()
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

    private fun collection_lambda() {
        CollectionDemo.listof()
        CollectionDemo.mutableListOf()

        CollectionDemo.setof()
        CollectionDemo.mutableSetOf()

        CollectionDemo.mapJava()
        CollectionDemo.mapKT()
        CollectionDemo.mapKT_simple()

        Lambda.getLongestFruit()
        Lambda.getLongestFruit2()
        Lambda.getLongestFruit22()
        Lambda.getLongestFruit222()
        Lambda.getLongestFruit_simple()// 极简写法

        CollectionAPI.mapAPI()
        CollectionAPI.filter()
        CollectionAPI.filterMap()
        CollectionAPI.any_all()

        JavaAPI.javaRunThread()
        JavaAPI.runThread_simple()
        JavaAPI.runThread_simple2()
        JavaAPI.runThread_simple3()// 执行一个线程的极简写法
        JavaAPI.onClickListener(this)// 点击事件的极简写法
    }

    private fun base2() {
        NullCheck.checkNull_if(null)
        NullCheck.checkNull_kt1(null)
        NullCheck.checkNull_kt2(null)
        // ?.和?:操作符连用
        NullCheck.checkNull_kt1_kt2(null)
        // 全局判空(断言)
        NullCheck.checkNull_global_assert()
        // 用let函数进行辅助判空，取代风险断言
        NullCheck.let(null)

        // 参数2设置了默认值，可以不传参数2
        ParamDefault.printDefault_param2(123)
        // 参数1设置了默认值，需要用键值对传参，因为编译器默认我们都是从参数1开始传参，不写键值对无法保证准确匹配参数
        ParamDefault.printDefault_param1(str = "传入参数")
        // 用键值对传参时，顺序无所谓
        ParamDefault.transParam_keyValue(str = "传入参数", num = 123)
    }

    private fun base3() {
        StandardFun.repeatCall()
        StandardFun.with()
        StandardFun.run()
        StandardFun.apply()

        StaticFun().objFun()// 必须用对象调用的普通方法
        StaticFun.staticFun()// 类似于静态方法的伴生单例类方法
        topStatic()// kotlin可以直接调用顶层方法
        JavaTest.test()// 从java调用kotlin的静态方法
    }

    private fun chapter4() {
        LateInit.doIt()// 延迟初始化

        // 密封类
        val result = Result.Success("成功回调")
        result.printResultMsg(result)
    }

    private fun chapter5() {
        ExpandFun.test()// 扩展函数
        ExpandFun.operator()// 扩展函数 * 运算符重载

        // 运算符重载：对象之间进行加减乘除等运算
        OperatorTest.test()
    }
}