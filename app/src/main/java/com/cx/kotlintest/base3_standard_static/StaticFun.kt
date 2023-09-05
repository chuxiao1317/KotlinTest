package com.cx.kotlintest.base3_standard_static

/**
 * 单例类中的所有方法都必须用类似于静态方法的调用方式
 * 如果只想要普通类中的某一个方法支持静态调用，就需要用到companion object
 * */
class StaticFun {
    fun objFun() {
        println("这是一个普通方法，需要用对象调用")
    }

    /**
     * 这其实不是静态方法，companion object会在类的内部创建一个伴生类，这个伴生类始终只会存在一个对象，类似于单例
     *
     * 单例类方法和伴生单例类方法都不能被java直接调用,除非加上@JvmStatic注解
     * */
    companion object {

        //这个注解只能加载单例或伴生单例类方法上
        @JvmStatic// 添加这个注解之后，java就可以直接静态调用这个方法了;
        fun staticFun() {
            println("这可以理解为一个静态方法，可以直接静态调用")
        }
    }


}