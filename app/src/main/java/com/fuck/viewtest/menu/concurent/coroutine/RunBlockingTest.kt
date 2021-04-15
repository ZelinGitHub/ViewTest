package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun fuckRunBlocking(){
    Thread{
        println("线程开始")
        runBlocking {
            println("协程开始")
            delay(3000)
            println("协程结束")
        }
        println("线程结束")
    }.start()
}