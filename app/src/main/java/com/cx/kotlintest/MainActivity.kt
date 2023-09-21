package com.cx.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cx.kotlintest.chapter9_infix.Infix
import com.cx.kotlintest.base.For
import com.cx.kotlintest.base.If
import com.cx.kotlintest.base.When
import com.cx.kotlintest.base2_null_paramDefault.ParamDefault
import com.cx.kotlintest.base1_oop_collection_lanmda.coolection_lambda.CollectionAPI
import com.cx.kotlintest.base1_oop_collection_lanmda.coolection_lambda.CollectionDemo
import com.cx.kotlintest.base1_oop_collection_lanmda.coolection_lambda.JavaAPI
import com.cx.kotlintest.base1_oop_collection_lanmda.coolection_lambda.Lambda
import com.cx.kotlintest.base2_null_paramDefault.NullCheck
import com.cx.kotlintest.base1_oop_collection_lanmda.oop.Phone
import com.cx.kotlintest.base1_oop_collection_lanmda.oop.Phone_data
import com.cx.kotlintest.base1_oop_collection_lanmda.oop.Student1
import com.cx.kotlintest.base3_standard_static.StandardFun
import com.cx.kotlintest.base3_standard_static.StaticFun
import com.cx.kotlintest.base3_standard_static.topStatic
import com.cx.kotlintest.chapter10_genericity_Higher.Reified
import com.cx.kotlintest.chapter10_genericity_Higher.covariation.Covariation
import com.cx.kotlintest.chapter10_genericity_Higher.covariation.ListVerify
import com.cx.kotlintest.chapter10_genericity_Higher.inversion.Inversion
import com.cx.kotlintest.chapter11_coroutine.Coroutine
import com.cx.kotlintest.chapter4_lateinit_sealed.LateInit
import com.cx.kotlintest.chapter4_lateinit_sealed.Result
import com.cx.kotlintest.chapter5_expand_operator.ExpandFun
import com.cx.kotlintest.chapter5_expand_operator.operator.OperatorTest
import com.cx.kotlintest.chapter6_higherFun.Crossline
import com.cx.kotlintest.chapter6_higherFun.HigherFun
import com.cx.kotlintest.chapter6_higherFun.Noinline
import com.cx.kotlintest.chapter7_higherFun_Apply.SpSimple
import com.cx.kotlintest.chapter8_genericity_entrust.Genericity
import com.cx.kotlintest.chapter8_genericity_entrust.Genericity.apply2
import com.cx.kotlintest.chapter8_genericity_entrust.entrust.byLazy.ByLazy
import com.cx.kotlintest.chapter8_genericity_entrust.entrust.byLazy.ByLazy_Mine
import kotlinx.coroutines.runBlocking
import kotlin.math.max

class MainActivity : AppCompatActivity() {

    /* todo 永远优先使用常量，除非不得不使用变量*/
    private var a = 1// var 是可变变量

    // val变量赋值以后，有【只读】性质
    private val b = 2// val 是不可变变量，即final，注意，js中并没有val，有的是var、let
    /* todo 永远优先使用常量，除非不得不使用变量*/

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

    /**
     * getLargerNum2简化
     *
     * 类似于变量的类型反推机制，= 后面的返回值会让编译器知道方法的返回值类型
     * 因此不必显式声明返回值类型
     * */
    private fun getLargerNum3(a: Int, b: Int) = max(a, b)

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
        // 高阶函数、内联、非内联
        chapter6()
        // 高阶函数应用：简化SP、数据库ContentValue（未完，暂先跳过）
        chapter7()
        // 泛型、委托、懒加载
        chapter8()
        // infix函数：优化可读性
        chapter9()
        // 泛型的高级特性：实化、协变、逆变
        chapter10()
        // 协程
        chapter11()
    }

    private fun base() {
        println("--------------------base--------------------")
        getLargerNum(a, b)
        getLargerNum2(b, c)
        getLargerNum3(b, c)

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
        println("--------------------oop--------------------")
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
        println("--------------------collection_lambda--------------------")
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
        println("--------------------base2--------------------")
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
        println("--------------------base3--------------------")
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
        println("--------------------chapter4--------------------")
        LateInit.doIt()// 延迟初始化

        // 密封类
        val result = Result.Success("成功回调")
        result.printResultMsg(result)
    }

    private fun chapter5() {
        println("--------------------chapter5--------------------")
        ExpandFun.test()// 扩展函数
        ExpandFun.operator()// 扩展函数 * 运算符重载

        // 运算符重载：对象之间进行加减乘除等运算
        OperatorTest.test()
    }

    private fun chapter6() {
        println("--------------------chapter6--------------------")
        HigherFun.base()
        HigherFun.lambda()

        // 对比内联函数和非内联函数的return，后者只能局部return
        Noinline.inlineMain()
        Noinline.noinlineMain()

        Crossline.runRunnable1 { }
    }

    private fun chapter7() {
        println("--------------------chapter7--------------------")
        SpSimple.oldWrite(this)
        SpSimple.newWrite(this)
        SpSimple.ktxSP(this)// kotlin原生的ktx扩展库自带的方法：简化SP调用

        SpSimple.read(this)
    }

    private fun chapter8() {
        println("--------------------chapter8--------------------")
        Genericity.toClass()// 泛型类

        //Genericity.toMethod<Int>("张三")// 泛型方法
        Genericity.toMethod("张三")// 泛型方法简化
        Genericity.toMethod(null)// 不指定上界时，泛型方法参数可为空

        Genericity.toMethodNum(123)// 限制上界为数字类型的泛型方法

        //Genericity.toMethod_NoNull(null)// todo 这行代码传null会报错
        Genericity.toMethod_NoNull(456)// 指定上界为Any

        val result = StringBuilder().apply2 {
            append("任何类型的变量都可以调用自建的泛型方法apply2，")
            append("用法与标准函数apply一模一样")
        }
        println(result)

        // 委托
        entrust()
    }

    /**
     * 委托
     * */
    private fun entrust() {
        // 委托的基本理解请看classEntrust、propEntrust目录，这里只是委托的应用

        ByLazy.test()// 原生懒加载：by lazy
        // todo：这个自定义懒加载没生效；另外也无法完全替代lazy，会标黄，报类型转换错误
        ByLazy_Mine.test()// 自定义懒加载：用于理解委托的应用
    }

    private fun chapter9() {
        println("--------------------chapter9--------------------")
        Infix.test()
    }

    /**
     * 协变：定义一个myClass<T>、class A、class B, A是B子类， myClass<A>是myClass<B>的子类型，称myClass在T泛型上是协变的
     * 逆变：定义一个myClass<T>、class A、class B, A是B子类， myClass<B>是myClass<A>的子类型，称myClass在T泛型上是逆变的
     *
     * out位置：泛型类或泛型方法中输出数据的地方，可以理解为返回值位置（get）
     * in位置：接收数据的地方，可以理解为参数位置（set或构造方法）
     * */
    private fun chapter10() {
        println("--------------------chapter10--------------------")
        Reified.test(this)// 泛型实化

        Covariation.test()// 理解泛型的协变
        ListVerify.verify()// 验证List协变

        Inversion.test()// 理解泛型的逆变
    }

    private fun chapter11() {
        println("--------------------chapter11--------------------")
        Coroutine.test()// 协程最简单的用法
        Coroutine.apply(this)// 体验协程的优势

        // todo 这行代码会报错，因为非协程作用域、非挂起函数不能调用挂起函数
        //Coroutine.testDelay()
        //Coroutine.testCoroutineScope()
        runBlocking {
            Coroutine.testDelay()// 协程作用域调用挂起函数
            Coroutine.testCoroutineScope()// 挂起函数中调用launch()
        }
        Coroutine.testCoroutineScope2()
    }
}