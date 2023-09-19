package com.cx.kotlintest.chapter10_genericity_Higher.inversion

/**
 * Comparable用于比较两个对象大小，已经声明逆变，源码如下
 * */
interface SimpleComparable<in T> {
    operator fun compareTo(other: T): Int
}