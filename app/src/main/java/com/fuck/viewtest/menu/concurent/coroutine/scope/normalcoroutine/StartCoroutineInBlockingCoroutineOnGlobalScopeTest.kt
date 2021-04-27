package com.fuck.viewtest.menu.concurent.coroutine.scope.normalcoroutine

import kotlinx.coroutines.*






fun startCoroutineInBlockingCoroutineOnGlobalScope() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程开始执行")
            GlobalScope.launch {
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



