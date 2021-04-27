package com.fuck.viewtest.menu.concurent.coroutine.cancel

import kotlinx.coroutines.*


fun testYieldCancel(){
    Thread {
        runBlocking {
            println("协程1 开始执行")
            val job = this.launch {
                println("协程2 开始执行")
                val startTime = System.currentTimeMillis()
                var nextPrintTime = startTime
                var i = 0
                while (i < 6) {
                    // 一个执行计算的循环，只是为了占用 CPU
                    // 每秒打印消息两次
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        println("协程2 正在执行 ${i++} ...")
                        nextPrintTime += 500L
                    }
                    yield()
                }
                println("协程2 执行结束")
            }
            delay(2000L) // 延迟一段时间
            println("协程1 取消协程2")
            job.cancelAndJoin() // 取消协程2，等待协程2执行结束
            println("协程1 执行结束")
        }
    }.start()
}


