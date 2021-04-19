package com.fuck.viewtest.menu.concurent.coroutine.runblocking

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun runBlockingInStartScope() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块1开始执行")
            coroutineScope {
                println("作用域开始执行")
                runBlocking {
                    println("阻塞块2开始执行")
                    delay(3000L)
                    println("阻塞块2执行结束")
                }
                delay(1000L)
                println("作用域执行结束")
            }
            println("阻塞块1执行结束")
        }
        println("线程执行结束")
    }.start()

}
