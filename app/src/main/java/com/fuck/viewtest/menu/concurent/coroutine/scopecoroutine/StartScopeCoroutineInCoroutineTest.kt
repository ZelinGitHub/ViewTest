package com.fuck.viewtest.menu.concurent.coroutine.scopecoroutine

import kotlinx.coroutines.*

fun startScopeCoroutineInCoroutine() {
    Thread {
        println("线程开始")
        GlobalScope.launch {
            println("普通协程开始")
            coroutineScope {
                println("作用域协程开始")
                delay(3000)
                println("作用域协程结束")
            }
            println("普通协程结束")
        }
        Thread.sleep(1000)
        println("线程结束")
    }.start()
}

fun startTwoScopeCoroutineInCoroutine() {
    Thread {
        println("线程开始")
        GlobalScope.launch {
            println("普通协程开始")
            coroutineScope {
                println("作用域协程1开始")
                delay(3000)
                println("作用域协程1结束")
            }
            coroutineScope {
                println("作用域协程2开始")
                delay(3000)
                println("作用域协程2结束")
            }
            println("普通协程结束")
        }
        Thread.sleep(1000)
        println("线程结束")
    }.start()
}

fun startNestScopeCoroutineInCoroutine() {
    Thread {
        println("线程开始")
        GlobalScope.launch {
            println("普通协程开始")
            coroutineScope {
                println("作用域协程1开始")
                coroutineScope {
                    println("作用域协程2开始")
                    delay(3000)
                    println("作用域协程2结束")
                }
                delay(3000)
                println("作用域协程1结束")
            }
            println("普通协程结束")
        }
        Thread.sleep(1000)
        println("线程结束")
    }.start()
}