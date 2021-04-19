package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun runBlockingInCoroutine(){
    Thread{
        println("线程开始")
        GlobalScope.launch {
            println("全局作用域开启的协程开始")
            runBlocking {
                println("阻塞块开始")
                delay(3000)
                println("阻塞块结束")
            }
            println("全局作用域开启的协程结束")
        }
        Thread.sleep(1000)
        println("线程结束")
    }.start()
}