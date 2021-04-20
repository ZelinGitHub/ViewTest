package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.*


fun startScopeCoroutineInBlocking() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程开始执行")
            coroutineScope {
                println("作用域协程开始执行")
                delay(3000L)
                println("作用域协程执行结束")
            }
            println("阻塞块协程执行结束")
        }
        println("线程执行结束")
    }.start()
}

fun startTwoScopeCoroutineInBlocking() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程开始执行")
            coroutineScope {
                println("作用域协程1开始执行")
                delay(3000L)
                println("作用域协程1执行结束")
            }
            coroutineScope {
                println("作用域协程2开始执行")
                delay(3000L)
                println("作用域协程2执行结束")
            }
            println("阻塞块协程执行结束")
        }
        println("线程执行结束")
    }.start()
}

fun startNestScopeCoroutineInBlocking() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程开始执行")
            coroutineScope {
                println("作用域协程1开始执行")
                coroutineScope {
                    println("作用域协程2开始执行")
                    delay(3000L)
                    println("作用域协程2执行结束")
                }
                delay(3000L)
                println("作用域协程1执行结束")
            }
            println("阻塞块协程执行结束")
        }
        println("线程执行结束")
    }.start()
}





