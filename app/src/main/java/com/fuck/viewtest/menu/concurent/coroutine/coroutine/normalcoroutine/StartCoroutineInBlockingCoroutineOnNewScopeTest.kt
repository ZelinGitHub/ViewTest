package com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun startCoroutineInBlockingCoroutineOnNewScope() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程开始执行")
            val coroutineScope = CoroutineScope(kotlin.coroutines.coroutineContext)
            coroutineScope.launch {
                println("普通协程开始执行")
                delay(3000L)
                println("普通协程执行结束")
            }
            delay(1000L)
            println("阻塞块协程执行结束")
        }
        println("线程执行结束")
    }.start()
}
