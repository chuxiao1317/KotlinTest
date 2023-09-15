package com.cx.kotlintest.chapter8_genericity_entrust.entrust.byLazy

import kotlin.reflect.KProperty

// 只有不定义在任何类中的函数，才是顶层函数
fun <T> myLazy(block: () -> T) = MyLazy(block)

class MyLazy<T>(private val block: () -> T) {
    private var value: Any? = null
    operator fun getValue(any: Any?, prop: KProperty<*>): T {
        println("自定义懒加载getValue：$value")
        if (value == null) {
            value = block
        }
        return value as T// todo：这里标黄警告，待解决
    }
}