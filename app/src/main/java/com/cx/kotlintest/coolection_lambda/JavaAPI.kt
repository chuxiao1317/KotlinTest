package com.cx.kotlintest.coolection_lambda

import android.content.Context
import android.widget.Button

/**
 * 如果java接口中只有一个待实现方法，就可以使用函数式API
 * */
object JavaAPI {
    /**
     * java执行一个线程的普通写法
     * */
    fun javaRunThread() {
        Thread(object : Runnable {
            override fun run() {
                // todo
            }
        }).start()
    }

    fun runThread_simple() {
        Thread(Runnable {
            // todo
        }).start()
    }

    fun runThread_simple2() {
        Thread({
            // todo
        }).start()
    }

    fun runThread_simple3() {
        Thread {
            // todo
        }.start()
    }

    fun onClickListener(context: Context) {
        val button = Button(context)
        button.setOnClickListener {
            // todo
        }
    }
}