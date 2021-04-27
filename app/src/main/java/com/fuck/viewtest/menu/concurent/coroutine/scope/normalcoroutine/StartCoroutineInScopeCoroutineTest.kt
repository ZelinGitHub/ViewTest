package com.fuck.viewtest.menu.concurent.coroutine.scope.normalcoroutine

import kotlinx.coroutines.*


fun startCoroutineInScopeCoroutineOnParamScopeX() {
    Thread {
        println("线程 开始执行")
        runBlocking {
            coroutineScope {
                //使用参数CoroutineScope启动普通协程
                this.launch {
                    println("协程 开始执行")
                    delay(5000L)
                    println("协程 执行结束")
                }
                delay(1000L) // 延迟一段时间
            }
        }
        println("线程 执行结束")
    }.start()
}

fun startCoroutineInScopeCoroutineOnGlobalScopeX() {
    Thread {
        println("线程 开始执行")
        runBlocking {
            coroutineScope {
                GlobalScope.launch {
                    println("协程 开始执行")
                    delay(5000L)
                    println("协程 执行结束")
                }
                delay(1000L) // 延迟一段时间
            }
        }
        println("线程 执行结束")
    }.start()
}

fun startCoroutineInScopeCoroutineOnNewScopeX() {
    Thread {
        println("线程 开始执行")
        runBlocking {
            coroutineScope {
                CoroutineScope(kotlin.coroutines.coroutineContext).launch {
                    println("协程 开始执行")
                    delay(5000L)
                    println("协程 执行结束")
                }
                delay(1000L) // 延迟一段时间
            }
        }
        println("线程 执行结束")
    }.start()
}
