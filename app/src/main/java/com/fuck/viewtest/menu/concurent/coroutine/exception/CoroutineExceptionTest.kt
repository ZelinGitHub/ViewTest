package com.fuck.viewtest.menu.concurent.coroutine.exception

import kotlinx.coroutines.*


fun testExceptionOnParamScope() {
    Thread {
        println("线程 开始执行")
        runBlocking {
            println("阻塞块协程 开始执行")
            coroutineScope {
                println("作用域协程 开始执行")
                //使用参数CoroutineScope启动普通协程
                this.launch {
                    println("普通协程 开始执行")
                    delay(1000)
                    println("普通协程 异常")
                    val x=1/0
                    println("普通协程 执行结束")
                }
                delay(3000L) // 延迟一段时间
                println("作用域协程 执行结束")
            }
            println("阻塞块协程 执行结束")

        }
        println("线程 执行结束")

    }.start()
}


fun testExceptionOnParamScopeTwoCoroutine() {
    Thread {
        println("线程 开始执行")
        runBlocking {
            println("阻塞块协程 开始执行")
            coroutineScope {
                println("作用域协程 开始执行")
                //使用参数CoroutineScope启动普通协程
                this.launch {
                    println("普通协程1 开始执行")
                    delay(1000)
                    println("普通协程1 异常")
                    val x=1/0
                    println("普通协程1 执行结束")
                }
                this.launch {
                    println("普通协程2 开始执行")
                    delay(3000)
                    println("普通协程2 执行结束")
                }
                delay(3000L) // 延迟一段时间
                println("作用域协程 执行结束")
            }
            println("阻塞块协程 执行结束")

        }
        println("线程 执行结束")

    }.start()
}

fun testExceptionOnGlobalScope() {
    Thread {
        println("线程 开始执行")
        runBlocking {
            println("阻塞块协程 开始执行")
            coroutineScope {
                println("作用域协程 开始执行")
                //使用GlobalScope启动普通协程
                GlobalScope.launch {
                    println("普通协程 开始执行")
                    println("普通协程 异常")
                    val x=1/0
                    println("普通协程 执行结束")
                }
                delay(3000L) // 延迟一段时间
                println("作用域协程 执行结束")
            }
            println("阻塞块协程 执行结束")
        }
        println("线程 执行结束")
    }.start()
}
