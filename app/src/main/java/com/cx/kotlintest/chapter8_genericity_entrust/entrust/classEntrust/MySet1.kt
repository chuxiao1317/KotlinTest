package com.cx.kotlintest.chapter8_genericity_entrust.entrust.classEntrust

/**
 * by: 委托关键字，这样就不用写出那些调用默认实现方法的代码(可能会很多)，使代码简化
 * */
class MySet1<T>(private val helperSet: HashSet<T>) : Set<T> by helperSet {

    override fun isEmpty(): Boolean {
        // 可以单独对其中某些方法进行自己的实现，其它方法依然是默认实现
        return false
    }

}