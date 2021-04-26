package com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//调用coroutineScope开启作用域协程
suspend fun concurrentSum(): Int = coroutineScope {
    //使用coroutineScope的参数CoroutineScope开启异步协程
    val one = this.async { doSomethingUselessOne() }
    //使用coroutineScope的参数CoroutineScope开启异步协程
    val two = this.async { doSomethingUselessTwo() }
    //等待获取结果
    one.await() + two.await()
}

fun executeConcurrentSum() {
    Thread{
        runBlocking {
            //执行lambda，并得到lambda执行的时长
            val time = measureTimeMillis {
                println("The answer is ${concurrentSum()}")
            }
            println("Completed in $time ms")
        }
    }.start()
}

suspend fun doSomethingUselessOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUselessTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}
