package com.fuck.viewtest.menu.concurent.coroutine.scopecoroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

var acquired = 0

class Resource {
    init {
        acquired++
    } // Acquire the resource

    fun close() {
        acquired--
    } // Release the resource
}

fun startTimeoutCoroutineInCoroutine() {
    Thread {
        runBlocking {
            repeat(100_000) { // Launch 100K coroutines
                launch {
                    val resource = withTimeout(60) { // Timeout of 60 ms
                        delay(50) // Delay for 50 ms
                        Resource() // Acquire a resource and return it from withTimeout block
                    }
                    resource.close() // Release the resource
                }
            }
        }
        // Outside of runBlocking all coroutines have completed
        println(acquired) // Print the number of resources still acquired
    }.start()

}