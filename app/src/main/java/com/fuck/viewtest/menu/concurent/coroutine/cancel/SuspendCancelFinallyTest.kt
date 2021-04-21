package com.fuck.viewtest.menu.concurent.coroutine.cancel

import kotlinx.coroutines.*


fun testDelayCancelFinallyDelayWithContext() {
    Thread {
        runBlocking {
            println("协程1 开始执行")
            val job = this.launch {
                println("协程2 开始执行")
                try {
                    println("协程2 挂起")
                    delay(5000L)
                } finally {
                    println("协程2 进入finally")
                    println("协程2 活跃状态 ${this.isActive}")
                    withContext(NonCancellable) {
                        println("withContext协程 开始执行")
                        println("withContext协程 活跃状态 ${this.isActive}")
                        println("withContext协程 再次挂起")
                        delay(5000L)
                        println("withContext协程 执行结束")
                    }
                    println("协程2 执行结束")

                }
            }
            delay(2000L) // 延迟一段时间
            println("协程1 取消协程2")
            job.cancelAndJoin() // 取消协程2，等待协程2执行结束
            println("协程1 执行结束")
        }
    }.start()
}

