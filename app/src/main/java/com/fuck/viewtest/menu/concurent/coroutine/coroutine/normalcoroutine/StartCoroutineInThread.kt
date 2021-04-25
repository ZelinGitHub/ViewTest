package com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

//线程先执行结束，协程后执行结束
fun startCoroutineInThreadOnGlobalScope() {


    Thread {
        println("线程开始执行")
        //启动一个协程
        GlobalScope.launch {
            println("协程开始执行")
            // 等待1s，不会阻塞当前执行线程
            delay(3000L)
            println("协程执行结束")
        }
        Thread.sleep(1000)
        // 协程在等待时，线程还在执行
        println("线程执行结束")
    }.start()
}

//协程先执行结束，线程后执行结束
fun startCoroutineInThreadOnGlobalScope2() {
    Thread {
        println("线程开始执行")
        //启动一个协程
        GlobalScope.launch {
            println("协程开始执行")
            // 等待1s，不会阻塞当前执行线程
            delay(1000L)
            println("协程执行结束")
        }
        Thread.sleep(3000)
        // 协程在等待时，线程还在执行
        println("线程执行结束")
    }.start()
}

//










