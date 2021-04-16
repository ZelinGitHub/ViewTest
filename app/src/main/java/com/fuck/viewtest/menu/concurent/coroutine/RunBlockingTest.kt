package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun runBlockingInThread(){
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
fun runBlockingInCoroutine(){
    Thread{
        println("线程开始")
        GlobalScope.launch {
            println("全局作用域协程开始")
            runBlocking {
                println("阻塞块开始")
                delay(3000)
                println("阻塞块结束")
            }
            println("全局作用域协程结束")
        }
        Thread.sleep(1000)
        println("线程结束")
    }.start()
}

fun runBlockingWithReturnValue(){
    Thread{
        println("线程开始")
        val returnValue:String=runBlocking<String> {
            println("协程开始")
            delay(3000)
            println("协程结束")
            "abc"
        }
        println("returnValue: $returnValue")
        println("线程结束")
    }.start()
}

fun runBlockingWithReturnValue2(){
    Thread{
        println("线程开始")
        val returnValue=runBlocking {
            println("协程开始")
            delay(3000)
            println("协程结束")
        }
        println("returnValue: $returnValue")
        println("线程结束")
    }.start()
}