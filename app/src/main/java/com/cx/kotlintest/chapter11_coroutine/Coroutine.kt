package com.cx.kotlintest.chapter11_coroutine

import android.widget.Button
import com.cx.kotlintest.MainActivity
import com.cx.kotlintest.R
import kotlinx.coroutines.*

object Coroutine {
    fun test() {
        GlobalScope.launch {
            println("开启协程最简单的方式，属于顶层协程，一般不建议用")
            // todo 如果协程代码块中的程序在一秒内不能运行结束，会被强制中断
            // 类似于线程sleep，挂起当前协程，非阻塞式；只能在协程作用域或其它挂起函数中调用
            delay(200)
        }
        // todo 某些情况（暂未遇到），上述代码会来不及运行，可以睡眠一段时间拖延程序结束
        //Thread.sleep(1000)

        // 如果协程代码块中的程序在一秒内不能运行结束，会被强制中断
        // 用runBlocking开启协程，能保证当前协程内的所有代码和协程执行完之前一直堵塞当前线程
        // runBlocking通常用于测试环境，用于正式环境可能引起性能问题
        runBlocking {
            println("开启协程的另一种方式")
            // 类似于线程sleep，挂起当前协程，非阻塞式；只能在协程作用域或其它挂起函数中调用
            delay(200)
            println("挂起结束")
        }
    }

    fun apply(context: MainActivity) {
        runBlocking {
            // launch函数只能用于协程作用于，不能“凭空”启用
            launch {
                println("协程1开始")
                delay(200)
                println("协程1挂起结束")
            }
            launch {
                println("协程2开始")
                delay(100)
                println("协程2挂起结束")
            }
        }

        context.findViewById<Button>(R.id.btn_coroutine_apply).setOnClickListener {
            val startTime = System.currentTimeMillis()
            runBlocking {
                repeat(10000) {
                    launch { print(".") }
                }
            }
            val endTime = System.currentTimeMillis()

            println()

            val startTime1 = System.currentTimeMillis()
            runBlocking {
                repeat(10000) {
                    Thread { print(".") }.start()
                }
            }
            val endTime1 = System.currentTimeMillis()

            println("\n并发执行10000个协程用时：${endTime - startTime}ms")
            println("\n并发执行10000个线程用时：${endTime1 - startTime1}ms")
        }
    }

    /**
     * delay()只能在协程作用域或挂起函数中使用
     * 而suspend可以把函数声明为挂起函数
     *
     * 但挂起函数只能从协程作用域或其它挂起函数中调用
     * */
    suspend fun testDelay() {
        println("测试delay函数，开始")
        // todo 如果不声明挂起函数，这行代码会报错
        delay(100)
        // todo 这里不能直接调用launch函数
        //launch {  }
        // todo 但是可以调用runBlocking
        runBlocking {}
        println("测试delay函数，结束")
    }

    /**
     * launch()是不能在非协程作用域调用的
     * coroutineScope可以让挂起函数中直接调用launch()，而不用额外开启协程
     * */
    suspend fun testCoroutineScope() = coroutineScope {
        launch {
            println("coroutineScope可以让挂起函数中直接调用launch()，而不用额外开启协程")
        }
    }

    /**
     * todo 与runBlocking类似，coroutineScope函数也能保证其作用域内代码和子协程执行完毕之前，阻塞当前协程
     *
     * coroutineScope与runBlocking类似作用类似，但runBlocking会阻塞当前线程
     * coroutineScope只阻塞当前协程，不影响其它线程和协程，因此不会造成任何性能问题
     *
     * 但coroutineScope只能在协程或挂起函数中调用
     * */
    fun testCoroutineScope2() {
        runBlocking {
            coroutineScope {
                launch {
                    for (i in 1..5) {
                        println(i)
                        delay(200)
                    }
                }
            }
            println("coroutineScope 执行完毕")
        }
        println("runBlocking 执行完毕")
    }
}