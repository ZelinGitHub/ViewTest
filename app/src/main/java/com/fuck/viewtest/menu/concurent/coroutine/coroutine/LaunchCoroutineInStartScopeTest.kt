package com.fuck.viewtest.menu.concurent.coroutine.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun startCoroutineInStartScope() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块开始执行")
            coroutineScope {
                println("作用域开始执行")
                this.launch {
                    println("作用域开启的协程开始执行")
                    delay(3000L)
                    println("作用域开启的协程执行结束")
                }
                delay(1000L)
                println("作用域执行结束")
            }
            println("阻塞块执行结束")
        }
        println("线程执行结束")
    }.start()

}


fun startCoroutineInStartScope2() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块开始执行")
            this.launch {
                println("作用域开启的协程1开始执行")
                delay(200L)
                println("作用域开启的协程1执行结束")
            }
            coroutineScope {
                println("作用域开始执行")
                this.launch {
                    println("作用域开启的协程2开始执行")
                    delay(500L)
                    println("作用域开启的协程2执行结束")
                }
                delay(100L)
                println("作用域执行结束")
            }
            println("阻塞块执行结束")
        }
        println("线程执行结束")
    }.start()

}