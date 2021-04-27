package com.fuck.viewtest.menu.concurent.coroutine.blockingcoroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun startBlockingCoroutineInScopeCoroutine() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程1开始执行")
            coroutineScope {
                println("作用域协程开始执行")
                runBlocking {
                    println("阻塞块协程2开始执行")
                    delay(3000L)
                    println("阻塞块协程2执行结束")
                }
                delay(1000L)
                println("作用域协程执行结束")
            }
            println("阻塞块协程1执行结束")
        }
        println("线程执行结束")
    }.start()

}
