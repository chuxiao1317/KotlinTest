package com.cx.kotlintest.chapter10_genericity_Higher

import android.content.Context
import android.content.Intent
import android.widget.TextView
import com.cx.kotlintest.ConstantCX
import com.cx.kotlintest.MainActivity
import com.cx.kotlintest.R
import com.cx.kotlintest.activities.TestActivity

/**
 * 泛型实化
 *
 * java1.5之前没有泛型，list取出数据需要手动强转
 * java泛型擦除机制：java1.5引入泛型，但泛型对于类型的约束只在编译期存在，运行的时候仍按jdk1.5之前的机制运行，jvm无法识别我们在代码中指定的泛型
 * */
object Reified {

    /**
     * reified关键字: 泛型实化
     * 声明后可直接返回泛型的实际类型 T.class，这在java中是不合法的
     *
     * 必须是内联函数
     * */
    inline fun <reified T> getGenericType() = T::class.java

    fun test(context: MainActivity) {
        val result1 = getGenericType<String>()
        val result2 = getGenericType<Number>()
        println("result1类型：$result1")
        println("result2类型：$result2")

        context.findViewById<TextView>(R.id.tv_jump1).setOnClickListener {
            // 无参跳转
            startActivity<TestActivity>(context)
        }
        context.findViewById<TextView>(R.id.tv_jump2).setOnClickListener {
            // 带参跳转
            startActivity<TestActivity>(context) {
                putExtra(ConstantCX.IntentTag.JUMP_NO_PARAM, "123")
            }
        }
    }

    /**
     * 利用泛型实化，可跳转任何未知的Activity
     *
     * 在java中，可以多传入一个根Activity参数作为替代方案
     * */
    private inline fun <reified T> startActivity(context: Context) {
        // 这里 T.class可以是任何Activity
        val intent = Intent(context, T::class.java)
        context.startActivity(intent)
    }

    /**
     * 添加一个方法型参数以便给intent传值
     * */
    private inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
        val intent = Intent(context, T::class.java)
        // 执行intent的传值逻辑
        intent.block()
        context.startActivity(intent)
    }
}