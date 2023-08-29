package com.cx.kotlintest.oop

/**
 * data：定义一个手机数据类
 * 参数：品牌、价格
 *
 * 数据类必须定义主构造方法
 * kotlin会自动适配equals、hashCode、toString等方法
 *
 * 当一个类中没有任何代码时，可以省略{}
 * */
data class Phone_data(val brand: String, val price: Double)