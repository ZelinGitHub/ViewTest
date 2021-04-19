package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.*


fun startCoroutineScopeInBlocking() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块开始执行")
            coroutineScope {
                println("作用域开始执行")
                delay(3000L)
                println("作用域执行结束")
            }
            println("阻塞块执行结束")
        }
        println("线程执行结束")
    }.start()
}

fun start2CoroutineScopeInBlocking() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块开始执行")
            coroutineScope {
                println("作用域1开始执行")
                delay(3000L)
                println("作用域1执行结束")
            }
            coroutineScope {
                println("作用域2开始执行")
                delay(3000L)
                println("作用域2执行结束")
            }
            println("阻塞块执行结束")
        }
        println("线程执行结束")
    }.start()
}

fun startNestCoroutineScopeInBlocking() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块开始执行")
            coroutineScope {
                println("作用域1开始执行")
                coroutineScope {
                    println("作用域2开始执行")
                    delay(3000L)
                    println("作用域2执行结束")
                }
                delay(3000L)
                println("作用域1执行结束")
            }
            println("阻塞块执行结束")
        }
        println("线程执行结束")
    }.start()
}





