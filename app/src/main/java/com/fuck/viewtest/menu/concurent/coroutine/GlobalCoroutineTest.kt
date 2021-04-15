package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

 
fun startGlobalScopeCoroutine() {
    Thread {
        println("线程开始执行")
        //启动一个协程
        GlobalScope.launch {
            println("协程开始执行")
            // 等待1s，不会阻塞当前执行线程
            delay(1000L)
            println("协程执行结束")

        }
        // 协程在等待时，线程还在执行
        println("线程执行结束")
    }.start()
}


fun startGlobalScopeCoroutine2() {
    runBlocking {
        GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }
}


fun startGlobalScopeCoroutine3() {
    runBlocking {
        val job = GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        job.join()
    }
}


fun startGlobalScopeCoroutine4() {
    GlobalScope.launch {
        fuck()
    }
    println("Hello,")
}


fun fuck() {
    println("World!")
}


fun startGlobalScopeCoroutine5() {
    GlobalScope.launch {
        suck()
    }
    println("Hello,")
}

suspend fun suck() {
    delay(1000L)
    println("World!")
}



