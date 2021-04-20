package com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine

import kotlinx.coroutines.*


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


fun startCoroutineInBlockingCoroutineOnNewScope() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程开始执行")
            val coroutineScope = CoroutineScope(kotlin.coroutines.coroutineContext)
            coroutineScope.launch {
                println("普通协程开始执行")
                delay(3000L)
                println("普通协程执行结束")
            }
            delay(1000L)
            println("阻塞块协程执行结束")
        }
        println("线程执行结束")
    }.start()
}


fun startCoroutineInBlockingCoroutineOnGlobalScope() {
    Thread {
        println("线程开始执行")
        runBlocking {
            println("阻塞块协程开始执行")
            GlobalScope.launch {
                println("普通协程开始执行")
                delay(3000L)
                println("普通协程执行结束")
            }
            delay(1000L)
            println("阻塞块协程执行结束")
        }
        println("线程执行结束")
    }.start()
}

fun testCoroutineWeigh(){
    Thread{
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
