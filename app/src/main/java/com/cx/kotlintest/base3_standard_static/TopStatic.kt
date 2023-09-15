package com.cx.kotlintest.base3_standard_static

// 只有不定在任何类当中的函数才是顶层函数
fun topStatic() {
    println("这是一个顶层方法，在kotlin中不管包名路径，可以直接调用；但是在java中，需要用TopStaticKt.topStatic()的方式来调用")
}