package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext


fun startGlobalScopeCoroutineInThread() {
    Thread {
        println("线程开始执行")
        //启动一个协程
        GlobalScope.launch {
            println("协程开始执行")
            // 等待1s，不会阻塞当前执行线程
            delay(1000L)
            println("协程执行结束")
        }
        // 协程在等待时，线程还在执行
        println("线程执行结束")
    }.start()
}


fun startGlobalScopeCoroutineInBlocking() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块开始执行")
            GlobalScope.launch {
                println("全局作用域协程开始执行")
                delay(1000L)
                println("全局作用域协程执行结束")
            }
            println("阻塞块执行结束")
        }
        println("线程执行结束")
    }.start()
}


fun testJobJoin() {
    Thread{
        println("线程开始执行")
        runBlocking {
            println("阻塞块开始执行")
            val job = GlobalScope.launch {
                println("全局作用域协程开始执行")
                delay(1000L)
                println("全局作用域协程执行结束")
            }
            println("全局作用域协程加入阻塞块")
            job.join()
            println("阻塞块执行结束")
        }
        println("线程执行结束")
    }
}





