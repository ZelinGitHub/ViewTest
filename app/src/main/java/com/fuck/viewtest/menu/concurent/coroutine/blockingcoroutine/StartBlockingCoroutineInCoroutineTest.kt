package com.fuck.viewtest.menu.concurent.coroutine.blockingcoroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun startBlockingCoroutineInCoroutine(){
    Thread{
        println("线程开始")
        GlobalScope.launch {
            println("普通协程开始")
            runBlocking {
                println("阻塞块协程开始")
                delay(3000)
                println("阻塞块协程结束")
            }
            println("普通协程结束")
        }
        Thread.sleep(1000)
        println("线程结束")
    }.start()
}