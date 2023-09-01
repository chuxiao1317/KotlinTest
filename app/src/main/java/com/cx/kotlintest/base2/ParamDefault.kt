package com.cx.kotlintest.base2

/**
 * 在java中，经常有些类会有多个构造方法，其中一些构造方法需要传入的参数较少，是因为这个构造方法会把没传入的参数设置一个默认值
 *
 * 在kotlin中，由于参数可以设置默认值，因此很多时候不必写那么多啰嗦的构造方法
 * */
object ParamDefault {
    /**
     * 若参数2设置了默认值，该参数可以不必传入，只传入参数1就可以
     * */
    fun printDefault_param2(num: Int, str: String = "默认参数") {
        println("num = $num, str = $str")
    }

    /**
     * 若参数1设置了默认值，就不能只传入参数2，因为编译器以为我们会把参数传给参数1
     * */
    fun printDefault_param1(num: Int = 0, str: String) {
        println("num = $num, str = $str")
    }

    /**
     * 用键值对传参
     * */
    fun transParam_keyValue(num: Int = 0, str: String = "默认参数") {
        println("num = $num, str = $str")
    }
}