package com.fuck.viewtest.menu.concurent.coroutine.coroutine.normalcoroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun executeTwoComputeNoConcur() {
    Thread {
        runBlocking {
            val time = measureTimeMillis {
                //两个函数顺序执行
                val one = doSomethingUsefulOne()
                val two = doSomethingUsefulTwo()
                println("The answer is ${one + two}")
            }
            println("Completed in $time ms")
        }
    }.start()
}


fun executeTwoComputeConcur() {
    Thread {
        runBlocking {
            val time = measureTimeMillis {
                //两个函数并行
                val one = this.async { doSomethingUsefulOne() }
                val two = this.async { doSomethingUsefulTwo() }
                println("The answer is ${one.await() + two.await()}")
            }
            println("Completed in $time ms")
        }
    }.start()
}

fun executeTwoComputeConcurLazyAndStart() {
    Thread {
        runBlocking {
            val time = measureTimeMillis {
                //两个函数并行
                val one = this.async(start = CoroutineStart.LAZY) {
                    doSomethingUsefulOne()
                }
                val two = this.async(start = CoroutineStart.LAZY) {
                    doSomethingUsefulTwo()
                }
                one.start()
                two.start()
                println("The answer is ${one.await() + two.await()}")
            }
            println("Completed in $time ms")
        }
    }.start()
}

fun executeTwoComputeConcurLazy() {
    Thread {
        runBlocking {
            val time = measureTimeMillis {
                //两个函数并行
                val one = this.async(start = CoroutineStart.LAZY) {
                    doSomethingUsefulOne()
                }
                val two = this.async(start = CoroutineStart.LAZY) {
                    doSomethingUsefulTwo()
                }
                println("The answer is ${one.await() + two.await()}")
            }
            println("Completed in $time ms")
        }
    }.start()
}


suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

