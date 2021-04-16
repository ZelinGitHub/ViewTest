package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext


fun startScopeCoroutineInBlocking() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking begin")
            //使用runBlocking函数传入的CoroutineScope实例，调用launch方法
            this.launch {
                println("scope coroutine begin")
                delay(5000L)
                println("scope coroutine end")
            }
            delay(1000L)
            println("blocking end")
        }
        println("thread end")
    }.start()
}

fun startScopeCoroutineInBlocking2() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking begin")
            //使用runBlocking函数传入的CoroutineScope实例，调用launch方法
            this.launch {
                println("scope coroutine begin")
                delay(1000L)
                println("scope coroutine end")
            }
            delay(3000L)
            println("blocking end")
        }
        println("thread end")
    }.start()
}


var mCoroutineScope: CoroutineScope? = null

//保存runBlocking的CoroutineScope实例
fun startBlockingAndSaveCoroutineScope() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking begin")
            mCoroutineScope = this
            startScopeCoroutineInBlocking3()
            delay(1000L)
            println("blocking end")
        }
        println("thread end")
    }.start()
}
//使用runBlocking的CoroutineScope实例启动协程
fun startScopeCoroutineInBlocking3() {
    mCoroutineScope?.launch {
        println("scope coroutine begin")
        delay(3000L)
        println("scope coroutine end")
    }
}




