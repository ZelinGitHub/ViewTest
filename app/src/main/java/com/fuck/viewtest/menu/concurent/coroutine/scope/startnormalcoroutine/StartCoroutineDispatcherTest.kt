package com.fuck.viewtest.menu.concurent.coroutine.scope.startnormalcoroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun startCoroutineWithParentDispatcher() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            //使用runBlocking函数传入的CoroutineScope实例，调用launch方法
            this.launch {
                println("normal coroutine begin")
                delay(3000L)
                println("normal coroutine end")
            }
            delay(1000L)
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}