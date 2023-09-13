package com.cx.kotlintest.chapter7_higherFunUse

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object SpSimple {

    /**
     * 常规sp存储数据写法
     * */
    fun oldWrite(context: Context) {
        val editor = context.getSharedPreferences("data", Context.MODE_PRIVATE).edit()
        editor.putString("name", "张三")
        editor.putInt("age", 18)
        editor.apply()
    }

    /**
     * 调用高阶函数:myExpandHigherFun
     * */
    fun newWrite(context: Context) {
        context.getSharedPreferences("data1", Context.MODE_PRIVATE)
            .myExpandHigherFun {// 传入的参数是无参的，所以这里没有参数
                putString("name", "李四")
                putInt("age", 19)
            }
    }

    /**
     * 扩展 * 高阶函数，相当于写一个SpUtil.java的静态方法,可以多次复用
     * block：函数名
     * SharedPreferences.Editor.()：表示SharedPreferences.Editor下面的一个无参方法
     * */
    private fun SharedPreferences.myExpandHigherFun(block: SharedPreferences.Editor.() -> Unit) {
        val editor = edit()
        editor.block()
        editor.apply()
    }


    /**
     * 上面的代码只是为了熟悉高阶函数，实际上kotlin原生的ktx扩展库已经自带简化SP的方法
     * */
    fun ktxSP(context: Context) {
        context.getSharedPreferences("data2", Context.MODE_PRIVATE).edit {
            putString("name", "王五")
            putInt("age", 20)
        }
    }

    fun read(context: Context) {
        val sp = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        val sp1 = context.getSharedPreferences("data1", Context.MODE_PRIVATE)
        val sp2 = context.getSharedPreferences("data1", Context.MODE_PRIVATE)

        val name = sp.getString("name", "")
        val age = sp.getInt("age", 0)

        val name1 = sp1.getString("name", "")
        val age1 = sp1.getInt("age", 0)

        val name2 = sp2.getString("name", "")
        val age2 = sp2.getInt("age", 0)

        println("高阶函数简化sp：$name: ${age}岁, $name1, ${age1}岁, $name2, ${age2}岁")
    }
}