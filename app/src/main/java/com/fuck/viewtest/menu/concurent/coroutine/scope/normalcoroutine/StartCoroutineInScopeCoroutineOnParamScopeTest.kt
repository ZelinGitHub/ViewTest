package com.fuck.viewtest.menu.concurent.coroutine.scope.normalcoroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun startCoroutineInScopeCoroutineOnParamScope() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块线程开始执行")
            coroutineScope {
                println("作用域线程开始执行")
                this.launch {
                    println("普通协程开始执行")
                    delay(3000L)
                    println("普通协程执行结束")
                }
                delay(1000L)
                println("作用域线程执行结束")
            }
            println("阻塞块线程执行结束")
        }
        println("线程执行结束")
    }.start()

}


fun startCoroutineInScopeCoroutineOnParamScope2() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程开始执行")
            this.launch {
                println("普通协程1开始执行")
                delay(200L)
                println("普通协程1执行结束")
            }
            coroutineScope {
                println("作用域协程开始执行")
                this.launch {
                    println("普通协程2开始执行")
                    delay(500L)
                    println("普通协程2执行结束")
                }
                delay(100L)
                println("作用域协程执行结束")
            }
            println("阻塞块协程执行结束")
        }
        println("线程执行结束")
    }.start()

}