package com.cx.kotlintest.chapter8_genericity_entrust

/**
 * 泛型类：T是约定俗成的写法，没有固定要求
 * */
class GenericityClass<T> {
    fun method(param: T): T {
        return param
    }

    /**
     * 泛型类里面的方法并无固定要求
     * */
    fun method1() {
        return
    }
}