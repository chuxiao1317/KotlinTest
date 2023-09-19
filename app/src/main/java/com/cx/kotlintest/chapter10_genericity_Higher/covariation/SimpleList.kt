package com.cx.kotlintest.chapter10_genericity_Higher.covariation

/**
 * 仿写一个简化版List，便于理解协变
 * list在kotlin中是只读的，MutableList才可以增删改
 * */
interface SimpleList<out T> : Collection<T> {
    override val size: Int

    override fun isEmpty(): Boolean

    // todo 这里泛型 T 不合法地出现在了in位置，但这里只用于判断而不是修改，因此是安全的
    //  此时可以用@UnsafeVariance通过编译，但这不能滥用
    override fun contains(element: @UnsafeVariance T): Boolean

    override fun iterator(): Iterator<T>

    public operator fun get(index: Int): T
}