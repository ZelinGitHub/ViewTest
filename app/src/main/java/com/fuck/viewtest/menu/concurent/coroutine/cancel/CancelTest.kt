package com.fuck.viewtest.menu.concurent.coroutine.cancel

import kotlinx.coroutines.*

fun testCancel(){
    Thread{
        runBlocking {
            println("协程1 开始运行")
            val job = this.launch(Dispatchers.Default) {
                println("协程2 开始运行")
                val startTime = System.currentTimeMillis()
                var nextPrintTime = startTime
                var i = 0
                while (this.isActive) { // 可以被取消的计算循环
                    // 每秒打印消息两次
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        println("协程2 正在运行 ${i++} ...")
                        nextPrintTime += 500L
                    }
                }
                println("协程2 运行结束")
            }
            delay(2000L) // 等待一段时间
            println("协程1 取消协程2")
            job.cancelAndJoin() // 取消该作业并等待它结束
            println("协程1 运行结束")
        }
    }.start()
}