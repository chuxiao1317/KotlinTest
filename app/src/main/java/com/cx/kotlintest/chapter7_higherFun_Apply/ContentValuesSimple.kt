package com.cx.kotlintest.chapter7_higherFun_Apply

import android.content.ContentValues

/**
 * todo: 这一节是简化数据库相关类用法的，公司业务较少用到，先跳过
 * */
object ContentValuesSimple {
    fun old() {
        val values = ContentValues()
        values.put("name", "张三")
        values.put("age", 18)
        values.put("sex", "男")

        // db.insert("Student", null, values)
    }
}