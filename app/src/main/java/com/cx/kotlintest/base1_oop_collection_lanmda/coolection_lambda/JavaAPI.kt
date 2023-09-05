package com.cx.kotlintest.base1_oop_collection_lanmda.coolection_lambda

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

            }
        }).start()
    }

    fun runThread_simple() {
        Thread(Runnable {

        }).start()
    }

    fun runThread_simple2() {
        Thread({

        }).start()
    }

    /**
     * 执行一个线程最简单的写法
     * */
    fun runThread_simple3() {
        Thread {

        }.start()
    }

    /**
     * 点击事件的简单写法
     * */
    fun onClickListener(context: Context) {
        val button = Button(context)
        button.setOnClickListener {

        }
    }
}