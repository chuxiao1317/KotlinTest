package com.cx.kotlintest.chapter5_expand_operator

/**
 * String 类没有这个方法，而且不可被继承，因此我们给它从外部添加一个扩展函数
 * 这种扩展函数一般定义成顶层方法，方便整个项目使用
 *
 * 这个类一般定义为要扩展的那个类的同名kt文件，方便查找
 *
 * 不用传参，因为扩展函数可以理解为继承了某个类并添加新的方法，因此this就是参数，即调用对象
 * */
fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        // str.isLetter: 判断是不是一个字母
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

/*/**
 * 运算符重载：让字符串拥有与数字相乘的能力
 * 如“abc” * 2 = “abcabc”
 * */
operator fun String.times(n: Int): String {
    val builder = StringBuilder()
    // 标准函数：执行指定次数的给定函数操作。
    // 当前迭代的从零开始的索引作为参数传递给操作。
    repeat(n) {
        builder.append(this)
    }
    return builder.toString()
}*/

// 上一个方法的简化
// str.repeat(n):返回包含重复n次的此字符序列的字符串。
operator fun String.times(n: Int) = repeat(n)