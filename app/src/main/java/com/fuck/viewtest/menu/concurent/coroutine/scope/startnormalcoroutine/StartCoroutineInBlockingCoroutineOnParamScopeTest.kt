package com.fuck.viewtest.menu.concurent.coroutine.scope.startnormalcoroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun startCoroutineInBlockingCoroutineOnParamScope() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            //使用runBlocking函数传入的CoroutineScope实例，调用launch方法
            this.launch {
                println("normal coroutine begin")
                delay(3000L)
                println("normal coroutine end")
            }
            delay(1000L)
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}

fun startCoroutineInBlockingCoroutineOnParamScope2() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            //使用runBlocking函数传入的CoroutineScope实例，调用launch方法
            this.launch {
                println("normal coroutine begin")
                delay(1000L)
                println("normal coroutine end")
            }
            delay(3000L)
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}


var mCoroutineScope: CoroutineScope? = null

//保存runBlocking的CoroutineScope实例
fun startBlockingCoroutineAndSaveParamScope() {
    Thread {
        println("thread begin")
        runBlocking {
            println("blocking coroutine begin")
            mCoroutineScope = this
            startCoroutineInBlockingCoroutineOnParamScope3()
            delay(1000L)
            println("blocking coroutine end")
        }
        println("thread end")
    }.start()
}

//使用runBlocking的CoroutineScope实例启动协程
fun startCoroutineInBlockingCoroutineOnParamScope3() {
    mCoroutineScope?.launch {
        println("normal coroutine begin")
        delay(3000L)
        println("normal coroutine end")
    }
}



fun testCoroutineWeigh() {
    Thread {
        runBlocking {
            repeat(100_000) { // 启动大量的协程
                this.launch {
                    delay(5000L)
                    print(".")
                }
            }
        }
    }.start()
}
