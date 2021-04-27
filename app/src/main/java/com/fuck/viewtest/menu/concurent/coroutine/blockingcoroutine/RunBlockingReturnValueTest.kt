package com.fuck.viewtest.menu.concurent.coroutine.blockingcoroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun runBlockingWithReturnValueStr() {
    Thread {
        println("线程开始")
        val returnValue: String = runBlocking<String> {
            println("协程开始")
            delay(3000)
            println("协程结束")
            "abc"
        }
        println("returnValue: $returnValue")
        println("线程结束")
    }.start()
}

fun runBlockingWithReturnValueUnit() {
    Thread {
        println("线程开始")
        val returnValue = runBlocking {
            println("协程开始")
            delay(3000)
            println("协程结束")
        }
        println("returnValue: $returnValue")
        println("线程结束")
    }.start()
}