package com.cx.kotlintest.chapter8_genericity_entrust.entrust.classEntrust

/**
 * 实现Set接口
 *
 * 类委托：将一个类的具体实现委托给另一个类完成
 * 类委托：重写接口方法但不做自己的具体实现，直接调用辅助对象的相应方法
 *
 * 可以自由决定哪些做具体实现，哪些直接调用接口方法
 * */
class MySet<T>(private val helperSet: HashSet<T>) : Set<T> {

    // 不做自己的实现，直接调用辅助对象的相应方法
    override val size: Int get() = helperSet.size

    // 不做自己的实现，直接调用辅助对象的相应方法
    override fun contains(element: T): Boolean = helperSet.contains(element)

    // 不做自己的实现，直接调用辅助对象的相应方法
    override fun containsAll(elements: Collection<T>): Boolean = helperSet.containsAll(elements)

    // 不做自己的实现，直接调用辅助对象的相应方法
    override fun isEmpty(): Boolean = helperSet.isEmpty()

    // 不做自己的实现，直接调用辅助对象的相应方法
    override fun iterator(): Iterator<T> = helperSet.iterator()
}