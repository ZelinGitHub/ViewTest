package com.fuck.viewtest.menu.concurent.coroutine

import kotlinx.coroutines.*

/*
协程runBlocking和协程runBlocking launch异步执行
在协程runBlocking launch执行完毕之前，协程runBlocking不会结束
协程CoroutineScope导致协程runBlocking挂起，二者同步执行，协程CoroutineScope先执行，协程runBlockin后执行
协程CoroutineScope、协程runBlocking launch、协程coroutineScope launch三者异步执行
在协程coroutineScope launch执行完毕之前，协程CoroutineScope不会结束
*/
fun createCoroutineScope() {
    runBlocking {
        launch {
            delay(200L)
            println("协程 runBlocking launch")
        }
        coroutineScope {
            launch {
                delay(500L)
                println("协程 coroutineScope launch")
            }
            delay(100L)
            println("协程 CoroutineScope")
        }
        println("协程 runBlocking")
    }
}




fun startScopeCoroutineOnNewScope() {
    runBlocking {
        //创建一个新的CoroutineScope
        //不过这种方法结构上不安全， 因为你不能再控制该方法执行的作用域
        val coroutineScope = CoroutineScope(kotlin.coroutines.coroutineContext)
        //使用新的CoroutineScope实例，调用launch方法
        coroutineScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }
}