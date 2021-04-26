package com.fuck.viewtest.menu.concurent.coroutine.delay

import kotlinx.coroutines.*


fun startTimeoutCoroutineInBlockingCoroutineNoTimeout() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            //启动超时协程
            val result: String = withTimeout(1300L) {
                println("timeout coroutine begin")
                println("timeout coroutine end")
                "abc"
            }
            println("blocking coroutine timeout coroutine result: $result")
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}


fun startTimeoutCoroutineInBlockingCoroutineHaveTimeout() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            //启动超时协程
            withTimeout(1300L) {
                println("timeout coroutine begin")
                //repeat是Kotlin的库函数，重复执行一个lambda
                repeat(1000) { i ->
                    println("I'm sleeping $i ...")
                    delay(500L)
                }
                println("timeout coroutine end")
            }
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}


fun startTimeoutCoroutineInBlockingCoroutineHaveTimeoutReturnNull() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            //启动超时协程
            val result: String? = withTimeoutOrNull(1300L) {
                println("timeout coroutine begin")
                //repeat是Kotlin的库函数，重复执行一个lambda
                repeat(1000) { i ->
                    println("I'm sleeping $i ...")
                    delay(500L)
                }
                println("timeout coroutine end")
                "ABC"
            }
            println("blocking coroutine timeout coroutine result: $result")
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}

fun startTimeoutCoroutineInScopeCoroutine() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            GlobalScope.launch {
                println("normal coroutine begin")
                //启动超时协程
                withTimeout(1300L) {
                    println("timeout coroutine begin")
                    //repeat是Kotlin的库函数，重复执行一个lambda
                    repeat(1000) { i ->
                        println("I'm sleeping $i ...")
                        delay(500L)
                    }
                    println("timeout coroutine end")
                }
                println("normal coroutine end")
            }
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}