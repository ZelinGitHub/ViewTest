package com.fuck.viewtest.menu.concurent.coroutine.delay

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun testJobJoin() {
    Thread{
        println("线程开始执行")
        runBlocking {
            println("阻塞块开始执行")
            val job = GlobalScope.launch {
                println("全局作用域开启的协程开始执行")
                delay(3000L)
                println("全局作用域开启的协程执行结束")
            }
            delay(1000L)
            println("全局作用域开启的协程加入阻塞块")
            job.join()
            println("阻塞块执行结束")
        }
        println("线程执行结束")
    }.start()
}
