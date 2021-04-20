package com.fuck.viewtest.menu.concurent.coroutine.cancel

import kotlinx.coroutines.*

fun testDelayCancel() {
    Thread {
        runBlocking {
            println("协程1 开始执行")
            val job = this.launch {
                println("协程2 开始执行")
                println("协程2 挂起")
                delay(5000L)
                println("协程2 执行结束")
            }
            delay(2000L) // 延迟一段时间
            println("协程1 取消协程2")
            job.cancel() // 取消协程2
            job.join() // 等待协程2执行结束
            println("协程1 执行结束")
        }
    }.start()

}

fun testDelayCancel2() {
    Thread {
        runBlocking {
            println("协程1 开始执行")
            val job = this.launch {
                println("协程2 开始执行")
                println("协程2 挂起")
                delay(5000L)
                println("协程2 执行结束")
            }
            delay(2000L) // 延迟一段时间
            println("协程1 取消协程2")
            job.cancelAndJoin() // 取消协程2，等待协程2执行结束
            println("协程1 执行结束")
        }
    }.start()

}

